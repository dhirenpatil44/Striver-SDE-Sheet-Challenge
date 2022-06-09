import java.util.*;

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

public class Set_Matrix_Zeroes {
    
    static void setZeroes(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;

        boolean firRow = false;
        boolean firCol = false;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0){
                    if(i==0) {
                        firRow = true;
                    }
                    
                    if(j==0) {
                        firCol = true;
                    }

                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(arr[0][j] == 0 || arr[i][0] == 0){
                    arr[i][j]=0;
                }
            }
        }
        
        if(firCol == true){
            for(int i=0; i<n; i++){
                arr[i][0] = 0;
            }
        }

        if(firRow == true){
            for(int j=0; j<m; j++){
                arr[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][]arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroes(arr);

        System.out.println(Arrays.deepToString(arr));
    }
}
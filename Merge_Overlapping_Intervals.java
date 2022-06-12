
import java.util.*;

// Given a collection of Intervals, the task is to merge all the overlapping Intervals.

// Time - (N log N)
// space - O(N)

public class Merge_Overlapping_Intervals {

    static int[][] overlappedInterval(int[][] arr)
    {
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        ArrayList<int[]> al = new ArrayList<>();

        for(int[]interval : arr){

            if(al.size() ==0){
                al.add(interval);

            }else{
                int[] prevInterval = al.get(al.size()-1);

                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(prevInterval[1],  interval[1]);
                }else{
                    al.add(interval);
                }
            }
        }
        return al.toArray(new int[al.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};

        System.out.println(Arrays.deepToString(overlappedInterval(arr)));
    }
}
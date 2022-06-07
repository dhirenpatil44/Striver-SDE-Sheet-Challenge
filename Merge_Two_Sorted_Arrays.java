import java.util.*;
public class Merge_Two_Sorted_Arrays {

    static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;
        int k = n - 1;

        while (i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                int temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;

                k--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }


    static int[] mergeArray(int[] arr1, int[] arr2, int n, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;

        while (i >= 0 && j >= 0) {
            if (arr1[i] < arr2[j]) {
                arr1[k--] = arr2[j--];

            } else {
                arr1[k--] = arr1[i--];
            }
        }

        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));


        // we can print both them as in one line also by simple for loop with (println) only print
    }
}
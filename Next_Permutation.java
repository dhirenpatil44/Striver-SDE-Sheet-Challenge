
// Here we have to find the next permutation of given no

// ex. arr = {3, 2, 1}
// output = 1 2 3

// Time - O(n)
// Space - O(1)


import java.util.Arrays;

public class Next_Permutation {

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }

    static void nextPermutation(int[] arr, int n) {
        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] < arr[i + 1]) {

                for (int j = n - 1; j >= 0; j--) {
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        reverse(arr, i + 1, n - 1);
                        return;
                    }
                }
            }
        }

        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
//        int[] arr = {3, 2, 1};
        int[] arr = {1, 2, 3, 6, 5, 4};

        nextPermutation(arr, arr.length);

        System.out.println(Arrays.toString(arr));

    }
}

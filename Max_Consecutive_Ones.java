
// Given a binary array arr of size N and an integer M.
// Find the maximum number of consecutive 1's produced by flipping at most M 0's.

// Ex.
// arr = 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0
// k = 2

// output = 6

// Explanation: [1, 1, 1, 0, 0, *1, *1, *1, *1*, *1, *1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

// Time - O(N)
// Space - O(1)

public class Max_Consecutive_Ones {

    static int longestOnes(int[] arr, int k) {
        int zero = 0;
        int i = 0;
        int res = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                zero++;
            }

            while (zero > k) {
                if (arr[i] == 0) {
                    zero--;
                }
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        System.out.println(longestOnes(arr, k));
    }
}

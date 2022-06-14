import java.util.HashMap;

// Given an array having both positive and negative integers.
// The task is to compute the length of the largest subarray with sum 0.

// Ex.
// arr = 15, -2, 2, -8, 1, 7, 10, 23
// output = 5

// Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7.


public class Largest_subarray_with_0_sum {

    static int maxLen(int[] arr, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int maxLen = -1;

        hm.put(sum, maxLen);

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (!hm.containsKey(sum)) {
                hm.put(sum, i);

            } else {
                maxLen = Math.max(maxLen, i - hm.get(sum));
            }
        }

        if (maxLen == -1)
            return 0;

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        System.out.println(maxLen(arr, arr.length));
    }
}

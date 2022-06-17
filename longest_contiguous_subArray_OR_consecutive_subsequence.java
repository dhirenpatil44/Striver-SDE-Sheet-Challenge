
import java.util.Arrays;
import java.util.HashSet;

// Longest consecutive subsequence

// Given an array of positive integers. Find the length of the longest sub-sequence such that
// elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

// ex.
// arr = 1, 9, 3, 10, 4, 20, 2
// output = 4

// Explanation: 1, 3, 4, 2 is the longest subsequence of consecutive elements

// Method 1:
// Time - O(n log n)
// Space - O(n)

// method 2:
// Time - O(N)
// space - O(N)


public class longest_contiguous_subArray_OR_consecutive_subsequence {


    // method 1 (optimal)
    static int longestConsecutive1(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        if (n == 0) {
            return 0;
        }

        int res = 1, cou = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] == arr[i - 1] + 1) {
                cou++;
            } else {
                cou = 1;
            }

            res = Math.max(res, cou);
        }

        return res;
    }

    // Method 2
    // gives TLE at code studio
    static int longestConsecutive2(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();

        int maxi = 0;

        for (int i = 0; i < n; i++)
            hs.add(arr[i]);

        for (int i = 0; i < n; i++) {
            if (!hs.contains(arr[i] - 1)) {

                int len = 0;

                int cur = arr[i];

                while (hs.contains(cur)) {
                    len++;
                    cur++;
                }

                maxi = Math.max(len, maxi);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {9, 15, 3, 2, 10, 4};

        System.out.println(longestConsecutive1(arr));

        System.out.println(longestConsecutive2(arr));
    }
}
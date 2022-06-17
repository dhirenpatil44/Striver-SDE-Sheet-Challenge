//Find the largest sum of contiguous subArray using Kadane's algorithm

// Time - O(n)
// Space - O(1)

public class Largest_Sum_Contiguous_SubArray_Kadanes_Algorithm {

    public static void main(String[] args) {
        int[] arr = {4, -2, -3, 4, -1, -3, 5, -3};

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int s = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            currentSum = currentSum + arr[i];

            if (maxSum < currentSum) {
                maxSum = currentSum;

                start = s; // Find starting index position of maximum sum of subArray
                end = i; // Find ending index position of maximum sum of subArray
            }

            if (currentSum < 0) {
                currentSum = 0;
                s = i + 1;
            }
        }

        System.out.println("Maximum sum of subArray is " + maxSum);
        System.out.println("Starting index position is " + start);
        System.out.println("Ending index position is " + end);
    }
}

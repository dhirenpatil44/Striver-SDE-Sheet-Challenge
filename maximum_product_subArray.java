// Time - O(n)
// Space - O(1)


public class maximum_product_subArray {

    static int maxProductSubArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(arr[i], arr[i] * max);
            min = Math.min(arr[i], arr[i] * min);

            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-6, 4, -5, 8, -10, 0, 8};

        System.out.println(maxProductSubArray(a));
    }
}
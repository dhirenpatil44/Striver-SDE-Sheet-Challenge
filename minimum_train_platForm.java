
// Find the minimum platform need to arrive and departure all train without disturbance

// Time - O(n log n)
// Space - O(1)

import java.util.Arrays;

public class minimum_train_platForm {

    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int max = 0, platform = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            } else {
                platform--;
                j++;
            }

            max = Math.max(max, platform);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arrival, departure, arrival.length));
    }
}

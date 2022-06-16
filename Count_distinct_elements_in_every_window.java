
import java.util.*;

// Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

// Time - O(N)
// Space - O(N)

public class Count_distinct_elements_in_every_window {

    static ArrayList<Integer> countDistinct(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        al.add(hm.size());

        for (int i = k; i < n; i++) {
            if (hm.get(arr[i - k]) == 1) {
                hm.remove(arr[i - k]);
            } else {
                hm.put(arr[i - k], hm.get(arr[i - k]) - 1);
            }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            al.add(hm.size());
        }

        return al;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        System.out.println(countDistinct(arr, arr.length, k));
    }
}

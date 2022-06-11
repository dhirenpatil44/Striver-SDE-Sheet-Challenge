
import java.util.PriorityQueue;

// Print the kth-Largest element from the unsorted array

// Use PriorityQueue of Min Heap
// because we have to find the Largest  (Vice versa)

// Arr = 7 10 4 3 20 15
// k = 3

// output = 10

// Time - O(N)
// Space - O(N log N)

public class Kth_Largest_element_in_array {

    static int kthLLarge(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(kthLLarge(arr, k));
    }
}

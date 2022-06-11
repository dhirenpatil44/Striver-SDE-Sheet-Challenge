
import java.util.Collections;
import java.util.PriorityQueue;

// Print the kth-Smallest element from the unsorted array

// Use PriorityQueue of Max Heap
// because we have to find the smallest  (Vice versa)

// Arr = 7 10 4 3 20 15
// k = 3

// output = 7


// Time - O(N)
// Space - O(N log N)

public class Kth_Smallest_element_in_array {

    static int kthSmall(int[] arr, int k) {
        // Collections.reverseOrder()   is for by default PriorityQueue is of  min heap
        // for convert max heap we need Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length ; i++) {
            if (pq.peek() > arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};

        System.out.println(kthSmall(arr,3));
    }
}

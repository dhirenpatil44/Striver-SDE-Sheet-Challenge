
import java.util.Arrays;
import java.util.Stack;

// we have given the array, and we have to find the distance between the
// current element with last greater element in array
// If there is no element previous greater element in array then return 1

// ex.
// arr =    100, 80, 60, 70, 60, 75, 85
// output = 1 1 1 2 1 4 6



// Time - O(n)
// Space - O(n)


public class Stock_span_problem {

    static int[] span(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = i + 1;
            } else {
                res[i] = (i - st.peek());
            }

            st.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};

        int[] res = span(arr, arr.length);

        System.out.println(Arrays.toString(res));
    }
}

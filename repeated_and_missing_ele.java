
import java.util.HashMap;

// find the missing and repeated element in array


public class repeated_and_missing_ele {

    static void sol(int[] arr) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int a : arr) {
            if (hm.get(a) == null) {
                hm.put(a, true);
            } else {
                System.out.println("Repeated ele is " + a);
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if (hm.get(i) == null) {
                System.out.println("Missing is " + i);
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 5, 6, 9, 8, 7};
        int[] arr = {2, 21, 17, 16, 22, 3, 9, 10, 14, 12, 20, 11, 6, 4, 8, 7, 23, 15, 18, 13, 1, 10, 19};
        sol(arr);
    }
}

import java.util.HashMap;

public class Pair_sum {

    static int getPairsCount(int[] arr, int k) {
        int cou = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int ele : arr) {
            if (hm.containsKey(k - ele)) {
                System.out.println(ele + " " + (k - ele));
                cou += hm.get(k - ele);
            }

            hm.put(ele, hm.getOrDefault(ele, 0) + 1);
        }

        return cou;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,1,7};
        int k = 6;

        System.out.println(getPairsCount(arr, k));
    }
}

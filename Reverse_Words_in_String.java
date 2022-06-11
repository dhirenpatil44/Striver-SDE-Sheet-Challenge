
// Given a String S, reverse the string without reversing its individual words. Words are separated by space .

// Time - O(n)
// Space - O(1)

public class Reverse_Words_in_String {

    static String reverseWords(String s) {
        String[] arr = s.trim().split(" +");

        String res = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i];
            if (i != 0)
                res += " ";

        }

        return res;
    }

    public static void main(String[] args) {
        String s = "a good   example";

        System.out.println(reverseWords(s));
    }
}

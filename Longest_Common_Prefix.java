public class Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] arr, int n) {
		String prefix = arr[0];

        for (int i = 1; i < n; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
	}

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(longestCommonPrefix(arr, arr.length));
    }
}
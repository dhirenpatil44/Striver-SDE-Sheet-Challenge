import java.util.*;

// Given array of characters and array of words
// we have to find the String of array words is present in the matrix
// for search word we can move all 8 direction
// if that word found then add to the list

// Ex.
// matrix = o a a n
//          e t a e
//          i h k r
//          i f l v

// words = "oath", "pea", "eat", "rain"

// Approach:
// simple DFS to all 8 direction

// Amazon Direct-i Facebook Google MakeMyTrip Microsoft Nvidia Yahoo

public class Word_Boggle_OR_Word_Search_2_DFS {

    static boolean search(char[][] arr, String s, int i, int j, int ind, boolean[][] visit) {
        // means we found whole string
        if (ind == s.length()) {
            return true;
        }

        // edge cases
        // don't go outside of matrix
        // not already visited
        // current matrix ele doesn't match with string character
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != s.charAt(ind) || visit[i][j]) {
            return false;
        }

        visit[i][j] = true;

        boolean up = search(arr, s, i - 1, j, ind + 1, visit);
        boolean down = search(arr, s, i + 1, j, ind + 1, visit);
        boolean right = search(arr, s, i, j + 1, ind + 1, visit);
        boolean left = search(arr, s, i, j - 1, ind + 1, visit);

        boolean upLeft = search(arr, s, i - 1, j - 1, ind + 1, visit);
        boolean upRight = search(arr, s, i - 1, j + 1, ind + 1, visit);
        boolean downLeft = search(arr, s, i + 1, j - 1, ind + 1, visit);
        boolean downRight = search(arr, s, i + 1, j + 1, ind + 1, visit);

        visit[i][j] = false;

        return up || down || right || left || upLeft || upRight || downLeft || downRight;
    }

    static String[] findWords(char[][] arr, String[] word) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] visit = new boolean[n][m];

        HashSet<String> hs = new HashSet<>();

        for (int ind = 0; ind < word.length; ind++) {
            String s = word[ind];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    
                    // start with string 1st character gets
                    // AND return true when search also return true
                    if (s.charAt(0) == arr[i][j] && search(arr, s, i, j, 0, visit)) {
                        hs.add(s);
                    }
                }
            }
        }

        String[] res = new String[hs.size()];

        int ind = 0;
        for (String s : hs) {
            res[ind++] = s;
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] arr = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

        String[] word = {"oath", "pea", "eat", "rain"};

        System.out.println(Arrays.toString(findWords(arr, word)));
    }
}

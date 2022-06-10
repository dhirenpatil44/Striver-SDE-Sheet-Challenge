
// Note : I am solved with DFS

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
// We can all 4 directions

// Ex.
// arr =    a g b c
//          q e e l
//          g b k s

// word = geeks

// output = true

// Explanation: The board is-   a "g b c
//                              q "e "e l
//                              g b "k "s

//The letters which are used to make the
//"geeks" are ".


// Approach:
// 1. regular searching in matrix by all direction with is return true or false

// Easy you understand by reading code


// Amazon Apple Intuit Microsoft

// Time - O(N * M)
// Space - O(N * M)


public class Word_Search_OR_Find_String_in_grid {

    static boolean search(char[][] arr, String s, int i, int j, int ind, boolean[][] visit) {
        if (ind == s.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != s.charAt(ind) || visit[i][j]) {
            return false;
        }

        visit[i][j] = true;

        boolean up = search(arr, s, i - 1, j, ind + 1, visit);
        boolean down = search(arr, s, i + 1, j, ind + 1, visit);
        boolean right = search(arr, s, i, j + 1, ind + 1, visit);
        boolean left = search(arr, s, i, j - 1, ind + 1, visit);

        visit[i][j] = false;

        return up || down || right || left;
    }


    static boolean isWordExist(char[][] arr, String s) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(0) == arr[i][j]) {

                    if (search(arr, s, i, j, 0, visit)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][]arr = {{'a','g','b','c'},{'q','e','e','l'},{'g','b','k','s'}};

        String word = "geeks";

        System.out.println(isWordExist(arr, word));
    }
}

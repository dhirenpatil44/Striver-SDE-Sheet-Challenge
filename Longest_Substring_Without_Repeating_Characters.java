import java.util.HashMap;

// Given a string s, find the length of the longest substring without repeating characters.

// Ex.
// s = abcabcbb

// output = 3

// Explanation: The answer is "abc", with the length of 3.

// Approach :
// 1. the substring lies between "i" and "j"
//      i -> right      j -> left
// 2. add the character with index to hashmap
// 3. when character is already present in the hashmap then set the new j as getting previous index of
//        character of i  + 1       so that that character will not add to new substring
// 4. also taking max of substring length


// Time - O(N)      N -> s.length
// Space - O(N)


public class Longest_Substring_Without_Repeating_Characters {

    static int longSub(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {

            if (hm.containsKey(s.charAt(i))) {
                j = Math.max(j, hm.get(s.charAt(i)) + 1);
            }

            hm.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(longSub(s));
    }
}

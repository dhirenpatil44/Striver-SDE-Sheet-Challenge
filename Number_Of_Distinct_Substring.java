// count the distinct substring

// Ex.
// s = abab
// output = 8

// Explanation:
// a, ab, aba, abab, b, ba, bab     these are the district substring


// approach:
// 1. run for loop from first char to last char and add to trie
// 2. then again second char to last char and add the trie
// 3. when char is not present in the trie then increase the count

// video - https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=5


// Time - O(N ^ 2)
// Space - we can't determine

// Note : If que also asked for empty substring then add one when return

public class Number_Of_Distinct_Substring{
    static class Node {
        Node[] links = new Node[26];

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }
    }

    static int distinctSubstring(String word) {
        int cou = 0;

        Node root = new Node();

        for (int i = 0; i < word.length(); i++) {
            Node node = root;

            for (int j = i; j < word.length(); j++) {
                if (!node.containsKey(word.charAt(j))) {
                    cou++;
                    node.put(word.charAt(j), new Node());
                }
                node = node.get(word.charAt(j));
            }
        }

        return cou;
    }

    public static void main(String[] args) {
        String s = "abab";

        System.out.println(distinctSubstring(s));
    }
}
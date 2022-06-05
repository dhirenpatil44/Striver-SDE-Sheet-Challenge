// find the longest string complete string

// complete string - string if every prefix of this string is also present in the array

// Ex.
// arr = n ni nin ninj ninja ninga
// output = ninja

public class Complete_String {

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }


    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.put(word.charAt(i), new Node());
                }

                node = node.get(word.charAt(i));
            }

            node.setEnd();
        }

        boolean checkPrefixExist(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));

                    if (node.isEnd() == false) {
                        return false;
                    }

                } else {
                    return false;
                }
            }

            return true;
        }
    }


    static String completeString(String[] word, int n) {
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(word[i]);
        }

        String longest = "";

        for (int i = 0; i < n; i++) {
            if (trie.checkPrefixExist(word[i])) {
                if (word[i].length() > longest.length()) {
                    longest = word[i];

                }else if(word[i].length() == longest.length() && word[i].compareTo(longest) < 0){
                    longest  = word[i];
                }
            }
        }

        if (longest == "") {
            return "None";
        }

        return longest;
    }

    public static void main(String[] args) {
        // String[] word = {"ab","bc" };
       String[] word = {"n", "ni", "nin", "ninj", "ninja", "ninga" };

        System.out.println(completeString(word, word.length));
    }
}

// Implement the trie

// Insert
// search
// startsWith

public class Implement_trie_I {

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
                    // add the new trie with current character
                    node.put(word.charAt(i), new Node());
                }

                // go to the next Trie
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }


        boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    return false;
                }

                // go to the next Trie
                node = node.get(word.charAt(i));
            }

            // at the end we got the true of trie means we got the string
            if (node.isEnd() == true) {
                return true;
            }

            return false;
        }


        boolean startWith(String prefix) {
            Node node = root;

            for (int i = 0; i < prefix.length(); i++) {
                if (!node.containsKey(prefix.charAt(i))) {
                    return false;
                }

                // go to the next Trie
                node = node.get(prefix.charAt(i));
            }

            // get not null means we got the prefix
            return true;
        }
    }

    public static void main(String[] args) {
        int[] type = {1, 1, 2, 3, 2};
        String[] value = {"hello", "help", "help", "hel", "hel"};

        int n = value.length;

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);

            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (type[i] == 3) {
                if (trie.startWith(value[i])) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            }
        }

    }
}

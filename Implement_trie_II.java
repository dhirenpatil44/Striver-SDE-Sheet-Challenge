// Implement the trie

// Operation
// 1. insert
// 2. count same word (of given word)
// 3. count same prefix words (all words which start with given prefix)
// 4. erase the word

public class Implement_trie_II {
    static class Node {
        Node[] links = new Node[26];
        int cntEndWith = 0;
        int cntPrefix = 0;

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void increaseEnd() {
            cntEndWith++;
        }

        void increasePrefix() {
            cntPrefix++;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        void reducePrefix() {
            cntPrefix--;
        }

        int getEnd() {
            return cntEndWith;
        }

        int getPrefix() {
            return cntPrefix;
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
                node.increasePrefix();
            }
            node.increaseEnd();
        }


        int countWordsEqualTo(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));

                } else {
                    return 0;
                }
            }
            return node.getEnd();
        }


        int countWordsStartingWith(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));

                } else {
                    return 0;
                }
            }

            return node.getPrefix();
        }


        void erase(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.get(word.charAt(i));
                    node.reducePrefix();
                } else {
                    return;
                }
            }

            node.deleteEnd();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("samsung");
        trie.insert("samsung");
        trie.insert("vivo");
        trie.erase("vivo");

        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsStartingWith("vi"));
    }
}
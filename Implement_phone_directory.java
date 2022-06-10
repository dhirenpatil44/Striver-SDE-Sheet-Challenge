import java.util.ArrayList;

public class Implement_phone_directory {

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public Node() {

        }

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


        void printSuggestion(Node cur, ArrayList<String> temp, StringBuilder prefix) {
            if (cur.isEnd()) {
                temp.add(prefix.toString());
            }

            for (char ch = 'a'; ch <= 'z'; ch++) {
                Node next = cur.get(ch);

                if (next != null) {
                    prefix.append(ch);
                    printSuggestion(next, temp, prefix);
                    prefix.deleteCharAt(prefix.length() - 1);

                }
            }
        }

        ArrayList<ArrayList<String>> getSuggestion(String s) {
            Node prev = root;
            ArrayList<ArrayList<String>> res = new ArrayList<>();
            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char lastCh = s.charAt(i);

                prefix.append(lastCh);

                Node cur = prev.get(lastCh);

                if (cur == null) {
                    break;
                }

                ArrayList<String> temp = new ArrayList<>();
                printSuggestion(cur, temp, prefix);

                res.add(temp);
                prev = cur;
            }

            return res;
        }
    }


    static ArrayList<ArrayList<String>> phoneDirectory(String[] contact, String s) {
        Trie trie = new Trie();

        for (int i = 0; i < contact.length; i++) {
            trie.insert(contact[i]);
        }
        
        return trie.getSuggestion(s);
    }

    public static void main(String[] args) {
        String[] arr = {"geeikistest", "geeksforgeeks", "geeksfortest"};

        String s = "geeips";

        System.out.println(phoneDirectory(arr, s));
    }
}
import java.util.*;

// Maximum XOR With an Element From Array

// we have given array of numbers and queries
// query = [1, 4] = [Xi, Ai]
// Xi = we have to do XOR of arr ele with this
// Ai = is the limit in from arr like here limit is 4
// find the maximum XOR we can get from each query

// Ex.
// arr = 5, 2, 4, 6, 6, 3
// queries = {{12, 4}, {8, 1}, {6, 3}}

// output = 15, -1, 5

// Approach:
// 1. sort arr
// 2. sort queries acc to limit
// 3. do XOR with Xi with limit Ai
// 4. bsc of ascending sorting we also set limit

// video - https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=8

public class Maximum_XOR_With_Element_From_Array {
    static class Node {
        Node[] links = new Node[2];

        boolean containsKey(int bit) {
            return links[bit] != null;
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }

        Node get(int bit) {
            return links[bit];
        }
    }


    static class Trie {
        static Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node node = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int getMax(int num) {
            Node node = root;
            int maxNum = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.containsKey(1 - bit)) {
                    maxNum = maxNum | (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }

            return maxNum;
        }
    }


    static int[] maximizeXor(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;

        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> offlineQue = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);

            offlineQue.add(temp);
        }

        Collections.sort(offlineQue, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });

        int[] res = new int[m];

        int ind = 0;

        Trie trie = new Trie();

        for (int i = 0; i < m; i++) {
            while (ind < n && arr[ind] <= offlineQue.get(i).get(0)) {
                trie.insert(arr[ind]);
                ind++;
            }

            int queryInd = offlineQue.get(i).get(2);

            if (ind != 0) {
                res[queryInd] = trie.getMax(offlineQue.get(i).get(1));
            } else {
                res[queryInd] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};

        System.out.println(Arrays.toString(maximizeXor(arr, queries)));
    }
}
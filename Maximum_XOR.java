// maximum XOR from two different array or (same array with 2 ele)

// Ex.
// arr1 = 25, 10, 2
// arr2 = 8, 5, 3

// output = 28

// Approach:
// 1. add the all ele to trie wih binary
// 2. then do XOR with ele of arr2 with trie

// video - https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6


// Time - O(N * 32) + O(M * 32)             N - length of arr1      M - length of arr2
// Space - can't determine

public class Maximum_XOR {

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


    static int findMaximumXOR(int[] arr1, int[] arr2) {
        Trie trie = new Trie();

        for (int ele : arr1) {
            trie.insert(ele);
        }

        int maxi = 0;
        for (int ele : arr2) {
            maxi = Math.max(maxi, trie.getMax(ele));
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr1 = {25, 10, 2};
        int[] arr2 = {8, 5, 3};

        System.out.println(findMaximumXOR(arr1, arr2));
    }
}

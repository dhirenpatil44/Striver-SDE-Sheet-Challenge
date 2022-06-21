
// ******************      This problem is of binary search.

// In this problem we have to allocate 'arr' books to 'k' students in that way like
// 1. We have to minimize the pages and give to the 'k' students
// 2. We have to give pages must in contiguous manner
// 3. We must have to give at least one book to each student
// 4. K Students cant share the one book    like 10 pages book and then cant share by 2 students


// Time - O(n log n)
// Space - O(1)

public class Allocation_of_books {

    static boolean valid(int[] arr, int n, int k, int mid) {

        int student = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            if (sum + arr[i] > mid) {
                student++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return student <= k;
    }

    static int findPages(int[] arr, int n, int k) {
        int min = 0;
        int max = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            if (valid(arr, n, k, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
//        int[] arr = {10,20,30,40};
        int n = arr.length;
        int k = 2;

        System.out.println(findPages(arr, n, k));
    }
}

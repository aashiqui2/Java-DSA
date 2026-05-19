public class Demo3 {
    //! Brute Forec Approach
    /* public static int upperBound(int[] arr, int x, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                // upper bound found:
                return i;
            }
        }
        return n;
    } */
    //? Time Complexity:O(n)
    // # The index of the first element in the array that is strictly greater than the given key.

    //! Optimal Approach
    public static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    //? Time Complexity: O(logn)

    public static void main(String[] args) {
        // int[] arr = { 3, 5, 8, 9, 15, 19 };
        int[] arr = { 1, 2, 3, 3, 7, 8, 9, 9, 9, 11 };
        int n =arr.length, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
    }
}

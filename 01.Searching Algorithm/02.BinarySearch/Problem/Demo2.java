public class Demo2 {
    // ! Brute Force Approach on (Linear Search)
    public static int lowerBound(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
             if (arr[i] >= x) {
                // lower bound found:
                return i;
            }
        }
        return n;
    }
    // ? Time Complexity: O(n)

    // ! Optimal Approach (Using Binary Search)
    /* public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    } */
    //? Time Complexity: O(log n)
    //# The index of the first element in the array that is greater than or equal to a given key.

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 7, 8, 9, 9, 9, 11 };
        int n = arr.length, x = 3;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}

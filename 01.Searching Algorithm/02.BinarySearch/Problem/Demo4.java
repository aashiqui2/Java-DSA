public class Demo4 {
    // ! Brute Force Approach
    /* public static int searchInsertPosition(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= key) {
                return i;
            }
        }
        return arr.length; // insert at end
    } */
    // ? Time Complexity: O(n)

    // ! Optimal Approach
    public static int searchInsertPosition(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid; // found
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // position to insert
    }
    //? Time Complexity:O(log n)

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 6 };
        int key = 4;

        int pos = searchInsertPosition(arr, key);
        System.out.println("Insert position: " + pos);
    }
}

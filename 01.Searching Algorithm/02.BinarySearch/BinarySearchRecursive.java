public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1; // Not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (key < arr[mid]) {
            return binarySearch(arr, low, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, high, key);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -15, -6, 0, 7, 9, 23, 54, 82, 101 };
        int key = 23;

        int index = binarySearch(arr, 0, arr.length - 1, key);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}
// ? Time Complexity: O(log n)

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume current index holds the minimum

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex]>arr[j] ) {
                    minIndex = j; // Update minIndex if smaller is found
                }
            }

            // Swap the found minimum element with the first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
//? Time Complexity:O(N^2)

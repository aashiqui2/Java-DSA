public class BubbleSortRecursive {
    static void bubbleSort(int[] arr, int n) {
        if (n == 1)
            return;

        boolean didSwap = false; // Track if any swap occurred

        // Perform one pass of bubble sort
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = true;
            }
        }

        // If no swaps were made, the array is already sorted
        if (!didSwap)
            return;

        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        int n = arr.length;
        bubbleSort(arr, n);

        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
}

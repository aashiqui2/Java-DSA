public class QuickSort {
    public static  int partition(int[] arr, int low, int high) {
        // Choose last element as pivot
        int pivot = arr[high];

        // Initialize i
        int i = low - 1;

        // Traverse from low to high-1
        for (int j = low; j < high; j++) {
            // If element <= pivot
            if (arr[j] <= pivot) {
                // Increment i and swap
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return pivot index
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        // Base case
        if (low < high) {
            // Find pivot index
            int pivotIndex = partition(arr, low, high);

            // Sort left subarray
            quickSort(arr, low, pivotIndex - 1);

            // Sort right subarray
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int a[] = { 6, 3, 9, 5, 2, 8 };
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
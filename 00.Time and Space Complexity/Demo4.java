public class Demo4 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // O(n)
            for (int j = 0; j < n - i - 1; j++) { // O(n)
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //? O(n^2) Quadratic Time
    //! Example: Bubble Sort
    
    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 3 };
        bubbleSort(arr);
        for (int n : arr)
            System.out.print(n + " ");
    }
}

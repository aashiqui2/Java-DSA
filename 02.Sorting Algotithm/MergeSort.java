import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void conquer(int a[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge both sorted parts
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                temp.add(a[left++]);
            } else {
                temp.add(a[right++]);
            }
        }
        // Add remaining left elements
        while (left <= mid) {
            temp.add(a[left++]);
        }

        // Add remaining right elements
        while (right <= high) {
            temp.add(a[right++]);
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            a[i] = temp.get(i - low);
        }
    }

    public static void divide(int a[], int low, int high) {
        if (low >= high) {
            return;
        }
        // Find mid index
        int mid = low + (high - low) / 2;
        // Sort left half
        divide(a, low, mid);
        // Sort right half
        divide(a, mid + 1, high);
        // Merge both halves
        conquer(a, low, mid, high);
    }

    public static void main(String[] args) {
        int a[] = { 6, 3, 9, 5, 2, 8 };
        int n = a.length;
        divide(a, 0, n - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
// ? Time Complexity: O(N*logN)

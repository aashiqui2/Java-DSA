public class LinearSearchRecursion {
    public static void linear_search_Recursive(int a[], int len, int idx, int data) {
        if (idx < len) {
            if (a[idx] == data) {
                System.out.println("Found");
                return;
            } else {
                linear_search_Recursive(a, len, idx + 1, data);
            }
        } else {
            System.out.println("Not Found");
            return;
        }
    }

    public static void main(String[] args) {

        int a[] = { -15, -6, 0, 7, 9, 23, 54, 82, 101 };
        int len = a.length;
        int k = 22;
        linear_search_Recursive(a, len, 0, k);
    }
}
//? Time Complexity:O(n)

public class LinearSearch {
    public static void main(String[] args) {
        int a[] = { -15, -6, 0, 7, 9, 23, 54, 82, 101 };
        int k = 82;

        if (searchLinear(a, k)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }

    public static boolean searchLinear(int[] a, int k) {
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (k == a[i]) {
               return flag=true;
            }
        }
        return flag;
    }
}
//? Time Complexity: O(n)

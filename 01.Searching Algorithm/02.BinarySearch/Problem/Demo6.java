public class Demo6 {
    // ! Brute Force Approach
   /*  public static int firstOccurence(int[] v, int key) {
        int res = -1;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            if (v[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    } */
    // ? Time Complexity:O(n)

    // ! Brute Force Approach
   /*  public static int lastOccurence(int[] v, int key) {
        int res = -1;
        int n = v.length;
        for (int i = n - 1; i >= 0; i--) {
            if (v[i] == key) {
                res = i;
                break;
            }
        }
        return res;
    } */
    // ? Time Complexity:O(n)

    public static int[] searchRange(int[] v, int key) {
        // return new int[] { firstOccurence(v, key), lastOccurence(v, key) };
        return new int[] { findFirstOccurrence(v, key), findLastOccurrence(v, key) };
    }

    //! Optimal Approach
    public static int findFirstOccurrence(int[] v, int key) {
        int start = 0, end = v.length - 1, res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                end = mid - 1;
            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    // ? Time Complexity:O(logn)

    public static int findLastOccurrence(int[] v, int key) {
        int start = 0, end = v.length - 1, res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (v[mid] == key) {
                res = mid;
                start = mid + 1;
            } else if (key < v[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
    // ? Time Complexity:O(logn)

    public static void main(String[] args) {
        int key = 13;
        int[] v = { 3, 4, 13, 13, 13, 20, 40 };
        int res[] = searchRange(v, key);
        System.out.println("The firstOccurence and LastOccurence are: " + res[0] + " " + res[1]);

    }
}

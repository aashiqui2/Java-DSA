public class Demo1 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -15, -6, 0, 7, 9, 23, 54, 82, 101 };
        int key = 23;
        if(search(arr, key)==-1)
        {
            System.out.println("Not Found");
        }
        else{
            System.out.println("Found");
        }
    }
}

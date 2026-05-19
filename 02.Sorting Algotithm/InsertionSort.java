public class InsertionSort {
    public static int[] insertionSort(int[] nums) {
        int n = nums.length; 
        for (int i = 1; i < n; i++) {
            int key = nums[i]; // Current element as key
            int j = i - 1;

            // Shift elements that are greater than key by one position
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key; // Insert key at correct position
        }

        return nums;  
    }

    public static void main(String[] args) {

        int[] nums = { 9,14,15,12,6,8,13};
        nums = insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
//? Time Complexity:  O(n^2)

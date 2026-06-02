public class Demo2 {
    public double findMaxAverage(int[] nums, int k) {
         int ws = 0;
        for (int i = 0; i < k; i++) {
            ws += nums[i];
        }
        int max = ws;
  
        for (int i = k; i < nums.length; i++) {
            ws = ws + nums[i] - nums[i - k];
            max = Math.max(ws, max);
        }
        return (double) max / k;
    }
    public static void main(String[] args) {
        int nums[] = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(new Demo2().findMaxAverage(nums,k));
    }
}
//! Time Complexity: O(n)
//! Link:(643) https://leetcode.com/problems/maximum-average-subarray-i/description/
import java.util.Arrays;

public class Demo6 {
    //! Memoization
    /* public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[index][prevIndex + 1]
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, -1, nums, dp);
    }
    public static int helper(int index, int prevIndex, int[] nums, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        // Option 1: Skip current element
        int notTake = helper(index + 1, prevIndex, nums, dp);

        // Option 2: Take current element
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + helper(index + 1, index, nums, dp);
        }
        dp[index][prevIndex + 1] = Math.max(take, notTake);
        return dp[index][prevIndex + 1];
    } */

    //! Tabulation
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, -1, 0, 6, 2, 3 };
        System.out.println(lengthOfLIS(a));
    }
}

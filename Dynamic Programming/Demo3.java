import java.util.Arrays;

public class Demo3 {
    //! Memoization
    /* public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(0, nums, dp);
    }

    public int helper(int i, int[] nums, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Pick current house
        int pick = nums[i] + helper(i + 2, nums, dp);

        // Skip current house
        int notPick = helper(i + 1, nums, dp);

        // Store answer
        dp[i] = Math.max(pick, notPick);

        return dp[i];
    } */

    //! Tabulation
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Demo3 d = new Demo3();
        int[] nums = { 2, 7, 3, 1, 4, 2, 1, 8 };
        System.out.println(d.rob(nums));

    }
}

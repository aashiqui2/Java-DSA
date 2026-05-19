import java.util.Arrays;

public class Demo2 {
    // ! using Memoization (top-down)
    /* public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); 
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    } */

    // ! using Tabulation (bottom-up)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Demo2 d= new Demo2();
        System.out.println(d.climbStairs(3));
    }
}

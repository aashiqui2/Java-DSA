import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        // int[] coins = {1, 2, 5};
        // int sum = 11;
        //! This fails for greedy approach
        int[] coins = {9, 6, 5, 1};
        int sum = 11; 
        System.out.println(coinChange(coins, sum));
    }

    //! Greedy Approach
    /*public static int coinChange(int[] coins,int sum)
    {
        Arrays.sort(coins);
        int count = 0;
        int remaining = sum;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (remaining >= coins[i]) {
                remaining = remaining-coins[i];
                count++;
            }
        }
        if (remaining == 0){
           return count;
        }
        else{
           return -1;
        }
    }*/
    
    //! Memoization Approach
    /*public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return helper(coins, amount, dp);
    }

    public static int helper(int[] coins, int rem, int[] dp) {
        if (rem == 0){
          return 0;
        }
        if (rem < 0) {
          return -1;
        }
        if (dp[rem] != -2){
          return dp[rem];
        } 
        int mini = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, dp);
            if (res >= 0 && res < mini){
               mini = 1 + res;
            }
        }
        dp[rem] = (mini == Integer.MAX_VALUE) ? -1 : mini;
        return dp[rem];
    }*/

    //! Tabulation
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // If coin can be used
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    // Update dp[i] with minimum coins
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

import java.util.Arrays;

public class Demo7 {

    //! Basic recursion
    /* public static int knapsack(int[] weights, int[] profits,int capacity,int index,int currentWeight,int currentProfit) {

        if (index == weights.length) {

            if (currentWeight <= capacity) {
                return currentProfit;
            }
            return 0;
        }

        int exclude = knapsack(weights, profits, capacity,index + 1,currentWeight,currentProfit);
        int include = 0;
        if (currentWeight + weights[index] <= capacity) {
            include = knapsack(weights, profits, capacity,index + 1, currentWeight + weights[index],currentProfit + profits[index]);
        }
        return Math.max(include, exclude);
    } */

    //! Memoization
    /*public static int knapsack(int[] weights, int[] profits,int capacity, int index,int[][] dp) {

        if (index == weights.length || capacity == 0) {
            return 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        // Exclude item
        int exclude = knapsack(weights, profits,capacity, index + 1, dp);

        // Include item
        int include = 0;
        if (weights[index] <= capacity) {
            include = profits[index] +knapsack(weights, profits,capacity - weights[index],index + 1, dp);
        }
        
        dp[index][capacity] = Math.max(include, exclude);
        return dp[index][capacity];
    }*/

    //! Tabulation
    public static int knapsack(int[] weights,int[] profits,int capacity){
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                // Not take item
                dp[i][w] = dp[i - 1][w];
                // Take item if possible
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w],profits[i - 1] + dp[i - 1][w - weights[i - 1]]);
                }
            }
        }
       return dp[n][capacity];
    }

    public static void main(String[] args) {

        int[] weights = {3, 4, 6, 5};
        int[] profits = {2, 3, 1, 4};
        int capacity = 8;

        // int maxProfit = knapsack(weights, profits, capacity,0, 0, 0);

        int[][] dp = new int[weights.length][capacity + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int maxProfit = knapsack(weights, profits, capacity,0,dp);
        //int maxProfit = knapsack(weights, profits, capacity);
        System.out.println("Maximum Profit = " + maxProfit);
    }
}

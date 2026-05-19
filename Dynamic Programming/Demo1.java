import java.util.Arrays;

public class Demo1 {
    // ! using memoization (top-down)
    /* public int fib(int n, int[] dp) {
        if (n <= 1){
            return n;
        } 
        if (dp[n] != -1){
            return dp[n];
        }
            
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    } */

    // ! using Tabulation (bottom-up)
    /* public int fib(int n) {
        if (n <= 1){
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    } */

    public int fib(int n) {
        if(n == 0) {
           return 0;
        }
        
        if(n == 1){
           return 1;
        } 

        int prev2 = 0;
        int prev = 1;
        int curr = 0;

        for(int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        Demo1 sol = new Demo1();
        System.out.println(sol.fib(n, dp));
        System.out.println(sol.fib(n));
    }
}

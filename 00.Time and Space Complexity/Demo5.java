public class Demo5 {
    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2); // 2 recursive calls → exponential
    }
    //? O(2^n) — Exponential Time
    //! Example: Fibonacci (Naive Recursion)

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " = " + fib(n));
    }
}

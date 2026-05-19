public class Demo8 {
    public static int countDigits(int n) {
        if (n < 0)
            n = -n; // Handle negative numbers
        if (n == 0)
            return 1;
        return 1 + countDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(countDigits(123));
    }
}
public class Demo9 {
    public static int productOfDigits(int n) {
        if (n < 0)
            n = -n; // Handle negative numbers
        if (n == 0)
            return 0;
        if (n < 10)
            return n;
        return (n % 10) * productOfDigits(n / 10);
    }

    public static void main(String[] args) {

    }
}

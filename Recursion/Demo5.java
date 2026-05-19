public class Demo5 {
    public static void fibonoci(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.print(c + " ");
        fibonoci(b, c, n - 1);
    }
    public static void main(String[] args) {
        fibonoci(0, 1, 5);
    }
}

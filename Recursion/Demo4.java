public class Demo4 {
    public static int findFact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * findFact(n - 1);
        }
    }

    public static void main(String[] args) {
        int n=5;
        /* int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact); */
        findFact(n);
    }
}

public class Demo2 {
    public static void printNumb(int n) {
        // !print 5-1
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumb(n - 1);

    }

    public static void main(String[] args) {
        /* for (int i = 5; i > 0; i--) {
            System.out.println(i);
        } */
        printNumb(5);
    }
}

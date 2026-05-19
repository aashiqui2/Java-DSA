public class Demo1 {
   public static void printNumb(int n) {
        // !print 1-5
        if(n>0)
        {
            printNumb(n-1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        /* for (int i = 0; i <5; i++) {
            System.out.println(i);
        } */

        printNumb(5);
    }
}

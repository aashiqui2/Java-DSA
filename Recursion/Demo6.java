public class Demo6 {
    public static double calcPower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if(n<0)
        {
            x=1/x;
            n=-(n);
        }
        if (n % 2 == 0) {
            return calcPower(x, n / 2) * calcPower(x, n / 2);
        } else {
            return calcPower(x, n / 2) * calcPower(x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(calcPower(2, 4));
    }
}

public class Demo7 {
    public static void sumDigit(int n,int sum)
    {
        if(n==0)
        {
            System.out.println(sum);
            return;
        }
        int rem=n%10;
        sumDigit(n/10, sum+rem);
    }
    public static void main(String[] args) {
        sumDigit(123, 0);
    }
}

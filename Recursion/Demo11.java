public class Demo11 {
    public static void printReverse(String s,int idx)
    {
        if(idx==0) 
        {
            System.out.print(s.charAt(idx));
            return;
        } 
        System.out.print(s.charAt(idx));
        printReverse(s, idx-1);
    }
    public static void main(String[] args) {
        String s="abc";
        printReverse(s, s.length()-1);
    }
}

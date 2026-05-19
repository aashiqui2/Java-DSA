public class BasicCalculator2 {
    public static void Calculate(String s)
    {
        int ans=0;
        int prevN=0;
        int currN=0;
        char op='+';
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                currN=currN*10+(c-'0');
            }
            if(!Character.isDigit(c) && c!=' '||i== s.length()-1)
            {

            }
        }
    }
    public static void main(String[] args) {
        string s="1+2*4";
        System.out.println(Calculate(s));
    }
}


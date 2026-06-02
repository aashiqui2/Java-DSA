public class Demo4 {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            while(!Character.isLetterOrDigit(left) && left<right){
                left++;
            }
            while(!Character.isLetterOrDigit(right) && left<right){
                right--;
            }
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(new Demo4().isPalindrome(s));
    }
}

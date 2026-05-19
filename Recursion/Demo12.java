public class Demo12 {
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("madam"));
    }
}

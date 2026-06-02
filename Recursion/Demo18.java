import java.util.HashSet;
public class Demo18 {
    public static void subsequence(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                set.add(newString);
                return;
            }
        }
        char currchar = str.charAt(idx);
        // to be
        subsequence(str, idx + 1, newString + currchar, set);
        // not to be
        subsequence(str, idx + 1, newString, set);
    }

    public static void main(String[] args) {
        String str="abc";
        HashSet<String> set=new HashSet<>();
        subsequence(str, 0, "",set);
        System.out.println(set);
    }
}
// Time complexity: O(2^n)

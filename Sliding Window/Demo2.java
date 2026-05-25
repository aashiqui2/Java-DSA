import java.util.*;
public class Demo2 {
    //! Brute Force approach
    public static List<String> repeatedDNA(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> added = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String current = s.substring(i, i + 10);
            for (int j = i + 1; j <= s.length() - 10; j++) {
                String next = s.substring(j, j + 10);
                if (current.equals(next)) {
                    if (!added.contains(current)) {
                        result.add(current);
                        added.add(current);
                    }
                    break;
                }
            }
        }
        return result;
    }
    //? Time Complexity: O(n^2)

    //! Sliding Window Approach
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String current = s.substring(i, i + 10);
            if (seen.contains(current)) {
                repeated.add(current);
            } else {
                seen.add(current);
            }
        }
        return new ArrayList<>(repeated);
    }
    //? Time Complexity: O(n)


    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(repeatedDNA(s));
    }
}
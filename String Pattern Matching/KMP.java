public class KMP {
    public static void main(String[] args) {
        /* String text = "abcdabcabcdf";
        String pattern = "abcdf"; */
       /*  String text = "aaaaaab";
        String pattern = "aaab"; */
        String text = "BABABABABCABABCABAB";
        String pattern = "ABABCABAB";

        int n = text.length();
        int m = pattern.length();
       // NaivePatternMatching(text, pattern, n, m);

       kmpSearch(text, pattern,n,m);
    }
    //! Brute Force Approach
    /* public static void NaivePatternMatching(String text, String pattern, int n, int m) {
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    } */
    // ! Time Complexity: O(n*m)

   /*  public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    } */

    public static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void kmpSearch(String text, String pattern,int n, int m) {
        int[] lps = buildLPS(pattern);
        System.out.println("Longest Prefix Suffix (LPS) array: "+ java.util.Arrays.toString(lps));

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index: " + (i - j));
                j = lps[j - 1]; // continue searching
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // jump using LPS
                } else {
                    i++;
                }
            }
        }
    }
}

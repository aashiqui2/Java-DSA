import java.util.*;

public class Demo5 {
    /* public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    } */
    /* public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch]++;
            while (freq[ch] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    } */
    public int lengthOfLongestSubstring(String s) {
        int left =0, maxLen=0;
        HashMap<Character,Integer>mp = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                left = Math.max(left, mp.get(s.charAt(i))+1);
            }
            mp.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }

        return maxLen;
        
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Demo5().lengthOfLongestSubstring(s));
    }
}

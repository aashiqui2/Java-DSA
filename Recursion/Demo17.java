public class Demo17 { 
    public static void removeDuplicates(String str, int idx, String newString,boolean[] map) {
        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currchar = str.charAt(idx);
        if (map[currchar - 'a']) {
            removeDuplicates(str, idx + 1, newString,map);
        }
        else{
            newString+=currchar;
            map[currchar-'a']=true;
            removeDuplicates(str, idx+1, newString,map);
        }
    }

    public static void main(String[] args) {
        String str = "abbccda";
        boolean map[] = new boolean[26];
        removeDuplicates(str, 0, "",map);
    }
}
//Time Complexity :O(n)

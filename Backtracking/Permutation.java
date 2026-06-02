import java.util.*;
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums,boolean[] used, List<Integer> current,List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, result);
            // Backtracking
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        Permutation p= new Permutation();
        List<List<Integer>> list=p.permute(nums);
        System.out.println(list);
    }
}
//! Time Complexity: O(n × n!)
//? Link: https://leetcode.com/problems/permutations/

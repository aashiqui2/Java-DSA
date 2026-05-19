import java.util.ArrayList;
import java.util.List;

public class Demo20 {
    public static void generateSubsets(int[] arr, int index, List<Integer> current,
            List<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current element
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        generateSubsets(arr, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(arr, 0, new ArrayList<>(), result);
        System.out.println(result);
    }
}

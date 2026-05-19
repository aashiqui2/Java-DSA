public class Demo10 {
    public static int findMax(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.max(arr[index], findMax(arr, index + 1));
    }

    public static int findMin(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return Math.min(arr[index], findMin(arr, index + 1));
    }

    public static void main(String[] args) {
        int []a={34,21,45,12,9};
        System.out.println(findMax(a, 0));
        System.out.println(findMin(a, 0));
    }
}

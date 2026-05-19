import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int a[] = { 29, 83, 471, 36, 91, 8 };
        System.out.println("Origin array "+ Arrays.toString(a));
        radixSort(a);
        System.out.println("sorted array "+ Arrays.toString(a));

    }

    public static void radixSort(int a[]) {
        int max = Arrays.stream(a).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(a, exp);
        }
    }

    public static void countingSort(int a[], int exp) {
        int n = a.length;
        int output[] = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(a[i] / exp) % 10]++;
        }
        // for(int i:count)
        // {
        // System.out.print(i+" ");
        // }
        // System.out.println();
        System.out.println(" count array for " + exp + " : " + Arrays.toString(count));

        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }

        System.out.println("Updated  array for " + exp + " : " + Arrays.toString(count));

        for(int i=n-1;i>=0;i--)
        {
            output[count[(a[i]/exp)%10]-1]=a[i];
            count[(a[i]/exp)%10]--;
        }
        System.arraycopy(output, 0, a, 0, n);
    }
}

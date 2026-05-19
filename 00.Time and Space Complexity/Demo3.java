public class Demo3 {
    public static void main(String[] args) {
        int a[]={6,3,9,5,2,8};
        divide(a,0,a.length-1);
        for(int i:a)
        {
            System.out.print(i+" ");
        }
    }
    public static  void divide(int a[],int si,int ei)
    {
        if(si>=ei)
        {
            return;
        }

        int mid =si+(ei-si)/2;
        divide(a,si,mid);
        divide(a,mid+1,ei);
        conquer(a,si,mid,ei);
    }
    public static void conquer(int arr[], int si, int mid, int ei) {
        int mergedSize = ei - si + 1;
        int merged[]=new int[mergedSize];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;
    
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
    
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
    
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }
    
        for (int i = 0, j = si; i < mergedSize; i++, j++) {
            arr[j] = merged[i];
        }
    }
    
}
//? O(n logn)	Log-Linear Time Complexity	
//! Example: Sorting the array using merge sort.

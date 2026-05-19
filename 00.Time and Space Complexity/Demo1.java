public class Demo1 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int k=8;
       System.out.println(binary_Search(arr,k));
    }
    public static boolean binary_Search(int [] a,int key)
    {
        int left=0,right=a.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(a[mid]==key)
            {
                return true;
            }
            else if(a[mid]<key){
                left=mid+1;
            }
            else {
                right= mid-1;
            }
        }
        return false;
    }
}
//? O(logn)	Logarithmic Time Complexity	
//! Example: Finding an element in a sorted array by using binary search.
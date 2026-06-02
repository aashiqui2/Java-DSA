public class Demo5 {
     /* public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area;
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    } */

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int area  = 0;
        int right = n-1;
        while(right>left){
            int curr = Math.min(height[left], height[right]) * (right-left);
            if(area < curr){
                area = curr;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(new Demo5().maxArea(height));
    }
}

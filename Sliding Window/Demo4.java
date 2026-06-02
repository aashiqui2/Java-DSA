public class Demo4 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        // Already satisfied customers
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }
        // First window
        int extra = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }
        int maxExtra = extra;
        // Sliding window
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];  
            }
            maxExtra = Math.max(maxExtra, extra);
        }
        return base + maxExtra;
    }
    public static void main(String[] args) {
       int[] customers = {1,0,1,2,1,1,7,5};
       int[] grumpy={0,1,0,1,0,1,0,1};
       int minutes=3;
       System.out.println(new Demo4().maxSatisfied(customers, grumpy, minutes));
    }
}

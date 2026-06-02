public class Demo21 {
    public static void towerOfHonai(int n,String src,String helper,String dest)
    {
        if(n==1)
        {
            System.out.println("transfer disk "+ n+ " from "+ src+" to "+dest);
            return;
        }
        towerOfHonai(n-1,src,dest,helper);
        System.out.println("transfer disk "+ n+ " from "+ src+" to "+dest);
        towerOfHonai(n-1, helper, src, dest);
        //source becomes helper,helper becomes destination
    }
    
    public static void main(String[] args) {
        //! Tower of Hanoi
        //! Rules
        /* 1.Only one disk transfered in 1 step
           2. smaller disk are kept at on top of large disks
         */
        int n=3;
        towerOfHonai(n," S", "H", "D");
    }
}

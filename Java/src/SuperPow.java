public class SuperPow{


    private int mod = 1337;

    public int superPowOld(int a, int[] b) {
        a = a % mod;
        return helper(a, b);
    }

    private int helper(int a, int[] b){
        if(b.length == 1){
            int res = 1;
            for(int i = 0; i < b[0]; i++){
                res = res * a;
                res = res % mod;
            }
            return res;
        }else{
            int res = 1;
            if(b[b.length-1]%2 == 1) {
                res = a;
                b[b.length-1]--;
            }
            int[] half = half(b);
            int ret = helper(a, half);

            res = (res * ret) % mod;
            res = (res * ret) % mod;
            return res;
        }
    }
    
    private int[] half(int[] b){
        int len = b.length;
        int srcIdx = 0;
        int dstIdx = 0;
        int rem = 0;

        if(b[0] == 1) {
            len = b.length-1;
            srcIdx = 1;
            rem = 1;
        }
        
        int[] res = new int[len];

        while(srcIdx < b.length){
            rem = rem * 10;
            rem += b[srcIdx];
            res[dstIdx] = rem / 2;
            rem = rem % 2;

            srcIdx++;
            dstIdx++;
        }

        return res;
    }

    public int superPow(int a, int[] b) {
        a = a % mod;

        int res = 1;
        for(int i = 0; i < b.length; i++){
            res = (pow(res, 10) * pow(a, b[i])) % mod;
        }
        return res;
    }

    private int pow(int a, int b){
        if(b == 0) return 1;
        int res = 1;
        for(int i = 0; i < b; i++){
            res = (res * a) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        SuperPow test = new SuperPow();
        int[] b = {5,6,7,4,9,1,4,4,6,9,4,5,8,9,2,1,3,2,8,9,9,6,1,7,4,3,1,7,2,0,0,4,8,7,8,8,8,5,4,7,4,1,2,5,0,4,6,6,8,4,5,9,3,8,7,9,3,0,6,6,3,6,2,1,5,0,1,5,7,8,2,4,9,6,9,1,2,5,7,1,1,2,0,6,3,9,5,6,0,1,4,3,9,6,6,6,9,8,4,6,8,8,0,7,5,1,8,7,6,6,0,0,0,3,6,5,2,2,2,4,5,8,9,7,5,6,5,6,6,9,2,4,8,5,3,5,8,1,2,5,9,5,7,2,8,3,7,2,7,1,9,3,2,8,2,7,4,7,3,2,9,7,6,7,4,9,2,3,3,6,0,4,1,7,8,1,0,8,6,0,9,5,3,1,3,7,0,0,6,5,4,5,5,1,4,9,2,8,4,7,5,4,2,8,3,2,2,4,0,8,6,2,5,9,5,0,8,6,0,4,3,5,0,8,8,6,0,2,5,4,0,2,1,4,2,4,6,4,0,9,4,6,1,9,7,6,0,5,4,2,0,0,9,2,8,9,8,0,2,5,5,4,7,8,0,0,2,8,4,3,7,1,9,0,0,7,7,2,2,3,7,4,3,6,8,4,6,7,6,0,2,1,4,2,9,4,2,4,2,8,7,2,9,8,2,2,5,1,6,0,5,3,6,0,2,5,6,8,4,3,8,8,6,4,0,8,0,2,2,2,1,9,6,2,7,9,4,5,0,1,7,7,6,3,8,8,8,6,8,2,9,8,1,6,2,3,4,2,6,8,7,9,7,3,3,6,2,8,3,5,1,0,2,9,4,2,8,4,9,6,9,8,5,2,6,9,5,2,2,3,0,1,2,7,4,6,6,9,6,1,6,9,2,8,0,8,3,8,2,2,7,1,2,4,3,9,3,1,1,7,4,2,8,9,1,5,7,9,6,5,1,2,4,3,2,6,1,5,5,5,7,4,9,0,8,4,1,3,5,2,1,0,6,1,9,0,8,6,9,4,1,0,6,7,5,1,3,8,6,0,6,4,4,5,6,4,9,7,8,5,1,1,7,0,2,8,0,3,6,9,7,9,2,6,6,7,7,1,8,3,4,4,9,0,1,7,5,0,6,5,7,0,6,4,0,0,2,0,3,0,1,3,9,3,1,5,3,8,9,3,3,3,9,5,5,0,4,0,0,1,7,8,1,5,4,3,6,9,5,1,9,6,6,9,2,7,6,7,5,7,0,1,2,9,6,8,1,0,0,1,3,8,1,6,3,8,9,1,9,4,3,8,3,9,9,5,7,8,2,4,5,4,7,8,5,5,6,6,8,6,9,1,6,3,8,0,3,9,3,2,6,8,2,9,8,2,4,7,0,8,3,7,4,1,5,1,8,3,9,6,2,8,0,8,3,0,0,6,9,4,8,5,4,1,4,2,5,0,1,7,0,7,4,6,0,0,7,8,3,8,7,7,9,7,6,2,7,8,1,8,4,9,4,9,2,0,3,7,3,7,4,5,6,1,2,6,1,1,6,6,0,5,4,9,2,2,3,1,2,4,0,9,6,6,8,8,6,3,8,1,0,4,7,8,5,9,6,8,0,3,7,2,8,1,1,3,5,5,4,9,1,6,8,7,2,6,6,1,2,6,2,4,0,9,3,8,0,9,6,3,4,3,5,5,6,9,8,3,6,4,3,7,1,1,5,5,0,3,6,2,9,1,6,1,2,9,9,3,1,8,8,5,3,3,0,0,4,8,3,0,5,8,0,8,0,7,3,0,0,2,4,1,5,0,2,7,2,4,2,3,4,0,8,7,4,9,9,0,9,5,1,6,3,3,4,5,0,0,5,0,4,1,1,9,4,5,8,6,1,1,1,5,1,9,3,7,0,4,8,2,9,1,0,3,4,5,8,4,7,6,6,3,7,9,4,3,4,2,9,8,3,0,3,7,2,8,4,4,3,2,8,2,5,9,7,9,6,8,5,5,4,1,8,3,0,2,7,7,4,8,5,0,1,0,7,3,9,1,9,4,6,8,8,1,9,6,3,5,4,8,2,0,0,0,5,2,4,4,9,0,3,6,0,4,7,7,9,8,1,0,2,9,0,0,0,9,8,5,6,2,4,8,4,6,0,0,8,4,4,0,5,9,8,5,5,5,5,6,3,6,7,7,7,7,0,7,7,8,3,3,3,9,4,7,7,4,7,7,9,4,7,4,3,6,1,1,3,6,7,9,4};
        // int[] h = test.half(b);
        System.out.print(test.superPow(3714151, b));
    }

}
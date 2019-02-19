
public class MinimumFactorization{

    public int smallestFactorization(int a) {
        if(a == 1) return 1;
        int[] fac = {9, 8, 7, 6, 5, 4, 3, 2};
        int[] count = new int [fac.length];
   
        while(a > 1){
            int i = 0;
            for(; i < fac.length; i++){
                if(a % fac[i] == 0){
                    count[i]++;
                    a = a / fac[i];
                    break;
                }
            }
            if(i == fac.length) return 0;
        }

        long res = 0;
        for(int i = fac.length-1; i >= 0; i--){
            for(int j = count[i]; j > 0; j--){
                res = res * 10;
                res += fac[i];
                if(res > Integer.MAX_VALUE) return 0;
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        MinimumFactorization test = new MinimumFactorization();
        System.out.print(test.smallestFactorization(15));
        
    }
}


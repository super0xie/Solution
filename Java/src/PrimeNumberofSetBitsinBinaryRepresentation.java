
public class PrimeNumberofSetBitsinBinaryRepresentation {
    
    private static boolean[] isPrime = {false, false, true, true, false, true, false, true
            , false, false, false, true, false, true, false, false, false, true, false, true, false};
    
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L; i <= R; i++) {
            if(isPrime[helper(i)]) res++;
        }
        return res;
    }
    
    private int helper(int i) {
        int c = 0;
        while(i > 0) {
            if(i % 2 == 1) c++;
            i = i >> 1;
        }
        return c;
    }
}

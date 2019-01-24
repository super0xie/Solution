
public class SubarraySumsDivisiblebyK {
    
    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K];
        int res = 0;
        int shift = 0;
        
        for(int i = 0; i < A.length; i++) {
            int mod = A[i] % K;
            if(mod < 0) mod += K;
            
            shift += mod;
            shift = shift % K;
            
            int idx = mod - shift;
            if(idx < 0) idx += K;
            
            count[idx]++;
            
            int zeroIdx = - shift;
            if(zeroIdx < 0) zeroIdx += K;
            
            res += count[zeroIdx];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        SubarraySumsDivisiblebyK test = new SubarraySumsDivisiblebyK();
        int[] A = {4,5,0,-2,-3,1};
        test.subarraysDivByK(A, 5);
    }
    
}

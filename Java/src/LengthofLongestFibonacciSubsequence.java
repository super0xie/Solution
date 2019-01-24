import java.util.HashMap;
import java.util.HashSet;

public class LengthofLongestFibonacciSubsequence {
    
    public int lenLongestFibSubseq(int[] A) {
        
        int res = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : A) set.add(i);
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for(int i = 2; i < A.length; i++) {
            for(int j = i-1; j > 0; j--) {
                int aux = A[i]-A[j];
                if(aux >= A[j]) break;
                
                if(set.contains(aux)) {
                    String key = A[j] + " " + A[i];
                    String preKey = aux + " " + A[j];
                    int len = 0;
                    if(map.containsKey(preKey)) len = map.get(preKey) + 1;
                    else len = 3;
                    
                    map.put(key, len);
                    res = Math.max(res, len);
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        LengthofLongestFibonacciSubsequence test = new LengthofLongestFibonacciSubsequence();
        int[] A = {1,3,7,11,12,14,18};
        System.out.println(test.lenLongestFibSubseq(A));
        
//        System.out.println("" + 3 + 4);
    }
    
}

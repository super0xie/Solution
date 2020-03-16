import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
    
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int mod = 1000000007;
        
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i : A) map.put(i, 1l);
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A[i]%A[j] == 0) {
                    int div = A[i]/A[j];
                    if(map.containsKey(div)) {
                        long count = map.get(A[i]) + map.get(A[j]) * map.get(div);
                        map.put(A[i], count);
                    }
                }
            }
        }
        
        long res = 0;
        for(int k : map.keySet()) {
            res += map.get(k);
        }
        return (int)(res % mod);
    }
    
    public static void main(String[] args) {
        BinaryTreesWithFactors test = new BinaryTreesWithFactors();
        int[] A = {45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48};
        System.out.println(test.numFactoredBinaryTrees(A));
    }
    
}

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    
    
    public int oddEvenJumpsOld(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int[][] target = new int [2][A.length];
        
        map.put(A[A.length-1], A.length-1);
        
        for(int i = A.length-2; i >= 0; i--) {
            Map.Entry<Integer, Integer> odd = map.ceilingEntry(A[i]);
            if(odd != null) target[0][i] = odd.getValue();
            Map.Entry<Integer, Integer> even = map.floorEntry(A[i]);
            if(even != null) target[1][i] = even.getValue();
            
            map.put(A[i], i);
        }
        
        int[][] cache = new int[2][A.length];
        cache[0][A.length-1] = 1;
        cache[1][A.length-1] = 1;
        
        int res = 1;
        for(int i = 0; i < A.length-1; i++) {
            if(helper(target, 0, i, cache)) res++;
        }
        
        return res;
        
    }
    
    public int oddEvenJumpsDP(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int[][] target = new int [2][A.length];
        
        map.put(A[A.length-1], A.length-1);
        boolean [][] canReach = new boolean[2][A.length];
        canReach[0][A.length-1] = true;
        canReach[1][A.length-1] = true;
        
        int res = 1;
        for(int i = A.length-2; i >= 0; i--) {
            Map.Entry<Integer, Integer> odd = map.ceilingEntry(A[i]);
            if(odd != null) {
                if(canReach[1][odd.getValue()]) {
                    res++;
                    canReach[0][i] = true;
                }
            }
            Map.Entry<Integer, Integer> even = map.floorEntry(A[i]);
            if(even != null) {
                if(canReach[0][even.getValue()]) {
                    canReach[1][i] = true;
                }
            }
            map.put(A[i], i);
        }
        
        return res;
    }
    
    //jump : 0 odd, 1 even 
    private boolean helper(int[][] tar, int jump, int idx, int[][] cache) {
        if(cache[jump][idx] != 0) return cache[jump][idx] == 1;
        
        int target = tar[jump][idx];
        boolean res = false;
        if(target != 0) {
            res = helper(tar, jump^1, target, cache);
        }
        
        if(res) cache[jump][idx] = 1;
        else cache[jump][idx] = 2;
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {5,1,3,4,2};
        OddEvenJump test = new OddEvenJump();
        test.oddEvenJumpsDP(A);
    }
    
}

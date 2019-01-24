import java.util.TreeMap;

public class AdvantageShuffle {
    
    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int [A.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : A) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i = 0; i < B.length; i++) {
            Integer n = map.ceilingKey(B[i]+1);
            if(n == null) {
                res[i] = map.firstKey();
            }else {
                res[i] = n;
            }
            
            int count = map.get(res[i]);
            if(count == 1) map.remove(res[i]);
            else map.put(res[i], count-1);
        }
        return res;
    }
    
    public static void main(String[] args) {
        AdvantageShuffle test = new AdvantageShuffle();
        int[] A = {2,0,4,1,2};
        int[] B = {1,3,0,0,2};
        test.advantageCount(A, B);
    }
}

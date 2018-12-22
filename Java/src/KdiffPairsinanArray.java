import java.util.HashMap;

public class KdiffPairsinanArray {
    
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int res = 0;
        for(int i : map.keySet()) {
            int tar = i + k;
            if(tar == i) {
                if(map.get(i) > 1) res++;
            } else if(map.containsKey(tar)) res++;
        }
        return res;
    }
    
}

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoArraysII {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : nums1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i : nums2) {
            if(map.containsKey(i)) {
                res.add(i);
                int count = map.get(i);
                count--;
                if(count == 0) map.remove(i);
                else map.put(i, count);
            }
            
        }
        
        int[] ret = new int[res.size()];
        
        for(int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        
        return ret;
                
    }
    
}

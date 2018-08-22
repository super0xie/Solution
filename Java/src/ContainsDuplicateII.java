import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);
                if(i - lastIndex <= k) return true;
                map.put(nums[i], i);
            }else {
                map.put(nums[i], i);
            } 
        }
        
        return false;       
    }

}

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {
	
	public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if(!map.containsKey(sum)) map.put(sum, i);
        	int sub = sum - k;
        	if(map.containsKey(sub)) {
        		res = Math.max(res, i-map.get(sub));
        	}
        }
        
        return res;
    }
	
}

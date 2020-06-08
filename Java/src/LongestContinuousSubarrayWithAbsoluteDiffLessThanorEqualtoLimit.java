import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
	
	public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0;
        int r = 0;
        int res = 1;
        map.put(nums[0], 1);
        while(r < nums.length) {
        	int min = map.firstKey();
        	int max = map.lastKey();
        	if(max-min <= limit) {
        		res = Math.max(res, r-l+1);
        		r++;
        		if(r < nums.length)
        			map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
        	}else {
        		map.put(nums[l], map.get(nums[l])-1);
        		if(map.get(nums[l]) == 0) map.remove(nums[l]);
        		l++;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit test = new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();
		System.out.println(test.longestSubarray(new int[] {4,2,2,2,4,4,2,2},0));
	}
	
}

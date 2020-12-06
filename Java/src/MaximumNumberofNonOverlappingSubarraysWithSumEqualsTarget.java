import java.util.HashMap;

public class MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
	

	public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] dp = new int[nums.length];
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	int pre = sum - target;
        	if(i > 0) dp[i] = dp[i-1];
        	if(map.containsKey(pre)) {
        		int idx = map.get(pre);
        		int c = 1;
        		if(idx >= 0) c = dp[idx]+1;
        		dp[i] = Math.max(dp[i], c);
        	}
        	
        	map.put(sum, i);
        }
        
        return dp[nums.length-1];
    }
	
	public static void main(String[] args) {
		MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget test = new MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget();
		int[] nums = {0,0,0};
		test.maxNonOverlapping(nums, 0);
	}
	
}

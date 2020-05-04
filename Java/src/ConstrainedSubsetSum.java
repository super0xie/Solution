import java.util.TreeMap;

public class ConstrainedSubsetSum {
	
	public int constrainedSubsetSumTLE(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        
        for(int i = 1; i < nums.length; i++) {
        	dp[i] = nums[i];
        	
        	for(int j = i-1; i-j <= k && j >= 0; j--) {
        		dp[i] = Math.max(dp[i], nums[i] + dp[j]);
        	}
        	res = Math.max(res, dp[i]);
        }
        
        return res;
    }
	
	public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
       	map.put(dp[0], 1);
        
        for(int i = 1; i < nums.length; i++) {
        	dp[i] = nums[i];
        	if(!map.isEmpty())
        		dp[i] = Math.max(dp[i], nums[i] + map.lastKey());
        	map.put(dp[i], map.getOrDefault(dp[i], 0)+1);
        	int j = i-k;
        	if(j >= 0) {
        		if(map.get(dp[j]) > 1) {
        			map.put(dp[j], map.get(dp[j])-1);
        		}else {
        			map.remove(dp[j]);
        		}
        	}
        	
        	res = Math.max(res, dp[i]);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		ConstrainedSubsetSum test = new ConstrainedSubsetSum();
		System.out.println(test.constrainedSubsetSum(new int[] {10,2,-10,5,20}, 2));
	}
}

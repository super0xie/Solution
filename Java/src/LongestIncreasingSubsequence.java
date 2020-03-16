import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public int lengthOfLISDFS(int[] nums) {
		if(nums.length == 0) return 0;
        int [] mem = new int [nums.length];
        Arrays.fill(mem, Integer.MIN_VALUE);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++) {
        	res = Math.max(res, dfs(nums, i, mem));
        }
        
        return res;
    }
	
	private int dfs(int[] nums, int startIndex, int[] mem) {
		if(mem[startIndex] != Integer.MIN_VALUE) return mem[startIndex];
		
		int res = 1;
		for(int i = startIndex+1; i < nums.length; i++) {
			if(nums[i] > nums[startIndex]) res = Math.max(res, 1 + dfs(nums, i, mem));
		}
		
		mem[startIndex] = res;
		return res;
	}
	
	public int lengthOfLISTail(int[] nums) {
	    if(nums.length == 0) return 0;
	    ArrayList<Integer> tails = new ArrayList<Integer>();
	    tails.add(nums[0]);
	    
	    for(int i = 1; i < nums.length; i++) {
	        
	        if(nums[i] > tails.get(tails.size()-1)) {
	            tails.add(nums[i]);
	        }else {
	            int l = 0;
	            int r = tails.size()-1;
	            while(l < r) {
	                int mid = l + (r-l)/2;
	                if(tails.get(mid) >= nums[i]) r = mid;
	                else l = mid+1;
	            }
	            
	            tails.set(l, nums[i]);
	        }
	        
	    }
	    
	    
	    return tails.size();
	}

	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int res = 1;

		for(int i = 1; i < nums.length; i++){
			dp[i] = 1;
			for(int j = i-1; j >= 0; j--){
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
					res = Math.max(res, dp[i]);
				}
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
		System.out.println(test.lengthOfLIS(nums));
	}

}

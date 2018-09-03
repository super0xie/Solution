import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public int lengthOfLIS(int[] nums) {
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
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
		System.out.println(test.lengthOfLIS(nums));
	}

}

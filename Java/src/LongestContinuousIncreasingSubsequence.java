
public class LongestContinuousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		if(nums.length == 0) return 0;
        int counter = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] > nums[i-1]) {
        		counter++;
        		res = Math.max(res, counter);
        	}else {
        		counter=1;
        	}
        }
        return res;
        
    }

}

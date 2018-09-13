import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		int minDiff = Integer.MAX_VALUE;
		
        for(int i = 0; i < nums.length-2; i++) {
        	int start = i+1;
        	int end = nums.length-1;
        	int tar = target - nums[i];
        	
        	
        	while(start < end) {
        		int sum = nums[start] + nums[end];
        		if(sum > tar) {
        			if(sum - tar < minDiff) {
        				res = sum + nums[i];
        				minDiff = sum-tar;
        			}
        			end--;
        		} else if(sum < tar) {
        			if(tar - sum < minDiff) {
        				res = sum + nums[i];
        				minDiff = tar - sum;
        			}
        			start++;
         		} else {
         			return sum+nums[i];
         		}
        	}
        	
        }
        
        return res;
    }
	
	public static void main(String[] args) {
//		int[] nums = {}
	}
	
}

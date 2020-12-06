import java.util.Arrays;

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
	
	public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        
        Arrays.parallelSort(nums);
        int res = Integer.MAX_VALUE;
        res = Math.min(res, nums[nums.length-1]-nums[3]);
        res = Math.min(res, nums[nums.length-2]-nums[2]);
        res = Math.min(res, nums[nums.length-3]-nums[1]);
        res = Math.min(res, nums[nums.length-4]-nums[0]);
        return res;
    }
}

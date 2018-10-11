import java.util.Arrays;

public class MaximumProductofThreeNumbers {
	public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int candA = nums[0] * nums[1] * nums[nums.length-1];
        int candB = nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1];
        return Math.max(candA, candB);
        
    }
}

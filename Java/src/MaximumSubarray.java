
public class MaximumSubarray {
	public int maxSubArrayV2(int[] nums) {
//		current max
		int max = nums[0];
//		sum from start of current max subarray to previous position
		int current= nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			if(current < 0) {
				if(nums[i] > max) {
					max = nums[i];
					current = max;
				}else {
					current += nums[i];
				}
			}else {
				if(nums[i] > 0) {
					max = Math.max(max, current+nums[i]);
					current += nums[i];
				}else {
					current += nums[i];
				}
			}
			
			
			
			
			System.out.println("h");
		}
		
		return max;
        
    }
	
	public int maxSubArray(int[] nums) {
		int[] adp = new int[nums.length];
		int[] bdp = new int[nums.length];
		
		adp[0] = nums[0];
		bdp[0] = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i++) {
			bdp[i] = Math.max(adp[i-1], bdp[i-1]);
			adp[i] = Math.max(nums[i], adp[i-1] + nums[i]);
		}
		
		return Math.max(adp[nums.length-1], bdp[nums.length-1]);
	}
	
	public static void main(String[] args) {
		MaximumSubarray test = new MaximumSubarray();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//		int[] nums = {8,-19,5,-4,20};
		System.out.println(test.maxSubArray(nums));
	}

}

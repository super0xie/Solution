
public class MinimumOperationstoReduceXtoZero {
	
	public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(x == sum) return nums.length;
        int target = sum - x;
        if(target <= 0) return -1;
        int l = 0;
        int r = -1;
        int res = Integer.MAX_VALUE;
        sum = 0;
        
        while(r < nums.length) {
        	if(sum > target) {
        		sum -= nums[l];
        		l++;
        	}else if(sum < target) {
        		r++;
        		if(r < nums.length) sum += nums[r];
        	}else if(sum == target) {
        		res = Math.min(res, nums.length-(r-l+1));
        		r++;
        		if(r < nums.length) sum += nums[r];
        	}
        }
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
	
	public static void main(String[] args) {
		MinimumOperationstoReduceXtoZero test = new MinimumOperationstoReduceXtoZero();
		int[] nums = {1,1};
		System.out.println(test.minOperations(nums, 3));
	}
	
}

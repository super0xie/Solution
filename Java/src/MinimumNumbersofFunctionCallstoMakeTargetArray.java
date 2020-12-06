
public class MinimumNumbersofFunctionCallstoMakeTargetArray {
	public int minOperations(int[] nums) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) continue;
        	res++;
        	int cur = 0;
        	
        	while(nums[i] > 1) {
        		if(nums[i] % 2 == 0) {
        			nums[i] /= 2;
        			cur++;
        		} else {
        			nums[i] -= 1;
        			res++;
        		}
        		
        	}
        	
        	
        	max = Math.max(max, cur);
        }
        
        return res + max;
    }
	
	public static void main(String[] args) {
		MinimumNumbersofFunctionCallstoMakeTargetArray test = new MinimumNumbersofFunctionCallstoMakeTargetArray();
		int[] nums = {1, 5};
		test.minOperations(nums);
	}
}

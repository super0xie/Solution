
public class MaximumLengthofSubarrayWithPositiveProduct {
	
	public int getMaxLen(int[] nums) {
        int s = 0;
        while(s < nums.length && nums[s] == 0) s++;
        int res = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = s; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		if(count % 2 == 0) {
        			res = Math.max(res, i-s);
        		} else {
        			res = Math.max(res, Math.max(i-min-1, max-s));
        		}
        		s = i+1;
        		count = 0;
        		min = Integer.MAX_VALUE;
        		max = Integer.MIN_VALUE;
        	}else {
        		if(nums[i] < 0) {
        			min = Math.min(min, i);
        			max = Math.max(max, i);
        			count++;
        		}
        	}
        }
        
        if(nums[nums.length-1] != 0) {
        	int i = nums.length-1;
        	if(count % 2 == 0) {
    			res = Math.max(res, i-s+1);
    		} else {
    			res = Math.max(res, Math.max(i-min, max-s));
    		}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		MaximumLengthofSubarrayWithPositiveProduct test = new MaximumLengthofSubarrayWithPositiveProduct();
		int[] nums = {5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2};
		System.out.println(test.getMaxLen(nums));
	}
	
}

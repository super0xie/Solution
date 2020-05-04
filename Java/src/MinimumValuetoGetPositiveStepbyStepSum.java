
public class MinimumValuetoGetPositiveStepbyStepSum {
	
	public int minStartValue(int[] nums) {
        int sum = 0;
        int min = sum;
        
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	min = Math.min(min, sum);
        }
        
        return 1-min;
    }
}

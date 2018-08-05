
public class RangeSumQueryImmutable {
	
	int[] sums;

    public void NumArray(int[] nums) {
    	sums = new int [nums.length];
    	
    	int sum = 0;
        for(int i=0; i < nums.length; i++) {
        	sum += nums[i];
        	sums[i] = sum;
        }
        
    }
    
    public int sumRange(int i, int j) {
    	if(i == 0) return sums[j];
        return sums[j] - sums[i - 1];
    }

}

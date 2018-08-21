
public class SingleNumber {
    public int singleNumber(int[] nums) {
    	if (nums.length == 1) return nums[0];
    	
    	int result = nums[0] ^ nums[1];
    	
    	for(int i = 2; i < nums.length; i++) {
    		result = nums[i] ^ result;
    	}
    	
    	return result;
        
    }
    
    public static void main(String[] args) {
    	
//    	System.out.println(2^0);
    	
    	int [] nums = {2,2,1};
    	
    	SingleNumber test = new SingleNumber();
    	System.out.println(test.singleNumber(nums));
    	
    	
    }

}

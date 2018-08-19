
public class RemoveDuplicatesfromSortedArray {
	
    public int removeDuplicates(int[] nums) {
    	if(nums == null) return 0;
    	if(nums.length <= 1) return nums.length;
    	
    	int insertLocation = 1;
    	int currentValue = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] != currentValue) {
    			nums[insertLocation++] = nums[i];
    			currentValue = nums[i];
    		}
    	}
    	
    	return insertLocation;

    }

}

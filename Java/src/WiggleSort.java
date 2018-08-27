
public class WiggleSort {
	
	
    public void wiggleSort(int[] nums) {
    	
    	boolean odd = false;
        for(int i = 0; i < nums.length-1; i++) {
        	if(odd) {
        		if(nums[i] < nums[i+1]) {
        			int temp = nums[i];
        			nums[i] = nums[i+1];
        			nums[i+1] = temp;
        		}
        	}else {
        		if(nums[i] > nums[i+1]) {
        			int temp = nums[i];
        			nums[i] = nums[i+1];
        			nums[i+1] = temp;
        		}
        	}
        	odd = !odd;
        }
    }
}

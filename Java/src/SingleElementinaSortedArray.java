
public class SingleElementinaSortedArray {
	
	public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length;
        int mid;
        
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	
        	if(mid < nums.length-1 && nums[mid] == nums[mid+1]) {
        		if(mid % 2 == 0) start++;
        		else end--;
        	}else if(mid > 0 && nums[mid] == nums[mid-1]) {
        		if(mid % 2 == 0) end--;
        		else start++;
        	}else {
        		return nums[mid];
        	}
        }
        
        return -1;
    }
	
}

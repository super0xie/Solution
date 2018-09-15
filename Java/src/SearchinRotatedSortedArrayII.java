
public class SearchinRotatedSortedArrayII {
	
	public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	if(target == nums[mid]) return true;
        	
        	if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
        		start++;
        		end--;
        	}else if(nums[mid] >= nums[start]) {
        		if(nums[mid] >= target && target >= nums[start]) end=mid-1;
        		else start = mid + 1;
        	}else if(nums[mid] <= nums[end]){
        		if(target <= nums[end] && target >= nums[mid]) start = mid+1;
        		else end = mid-1;
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		SearchinRotatedSortedArrayII test = new SearchinRotatedSortedArrayII();
		int[] nums = {1,3};
		test.search(nums, 3);
	}

}

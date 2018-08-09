
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
    	int length = nums.length;
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	if(target == nums[mid]) return mid;
        	
        	//mid at left of pivot
        	if(nums[mid] >  nums[length-1]) {
        		if(target > nums[mid] || target < nums[start]) 
        			start = mid+1;
        		else 
        			end = mid-1;
        	} 
        	//mid at right of pivot
        	else {
        		if(target < nums[mid] || target > nums[end])
        			end = mid-1;
        		else
        			start = mid+1;
        	}
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
    	SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
    	int [] nums = {4,5,6,7,0,1,2};
    	System.out.println(test.search(nums, 2));
    }

}

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
	
	public int[] searchRange(int[] nums, int target) {
		int res = Arrays.binarySearch(nums, target);
		if(res < 0) {
			return new int [] {-1,-1};
		}else {
			int i = res;
			int j = res;
			
			while(i-1 >= 0 && nums[i-1] == nums[res]) i--;
			while(j+1 < nums.length && nums[j+1] == nums[res]) j++;
			
			return new int[] {i,j};
		}
        
    }

}

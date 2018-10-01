import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
	
	public int[] searchRangeWorstON(int[] nums, int target) {
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
	
	//Guarantee logn
	public int[] searchRange(int[] nums, int target) {
		if(nums.length == 0) return new int [] {-1,-1};
		int i = 0;
		int j = nums.length-1;
		
		while(i < j) {
			int mid = i + (j-i)/2;
			if(nums[mid] < target) i = mid+1;
			else j = mid;
		}
		
		if(nums[i] != target) return new int [] {-1,-1};
		int left = i;
		
		i = 0;
		j = nums.length-1;
		
		while(i < j) {
			int mid = j - (j-i)/2;
			if(nums[mid] > target) j = mid - 1;
			else i = mid;
		}
		
		return new int[] {left, i};
	}

}

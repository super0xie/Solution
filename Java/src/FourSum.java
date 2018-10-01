import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < nums.length-3; i++) {
			
			for(int j = i+1; j < nums.length - 2; j++) {
				int tar = target - nums[i] - nums[j];;
				int l = j+1;
				int r = nums.length-1;

				while(l < r) {
					int sum = nums[l] + nums[r];
					if(sum < tar) {
						l++;
					}else if(sum > tar) {
						r--;
					}else {
						res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
						while(l < nums.length-1 && nums[l+1] == nums[l]) l++;
						while(r > 0 && nums[r-1] == nums[r]) r--;
						l++;
						r--;
					}
				}
				
				while(j < nums.length-1 && nums[j+1] == nums[j]) j++;
			}
			while(i < nums.length-1 && nums[i+1] == nums[i]) i++;
		}
		return res;
		
    }
	
	public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		FourSum test = new FourSum();
		test.fourSum(nums, 0);
	}

}

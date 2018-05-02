import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        int min_i = 0;
        int max_j = nums.length - 1;
        while(min_i < max_j - 1) {
        	int target = -nums[min_i] - nums[max_j];
        	if(target < nums[min_i]) {
        		max_j--;
        		continue;
        	}
        	else if(target > nums[max_j]) {
        		min_i++;
        		continue;
        	}else {
        		break;
        	}
        }
        
        int i = min_i;
        int j = max_j;
        
        for(; i < max_j - 1;) {
        	
        	j = max_j;
        	while(i < j - 1) {
        		int target = -nums[i] - nums[j];
            	if(target < nums[i]) {
            		j--;
            	}else {
            		break;
            	}
        	}
        	max_j = j;
        	
        	for(; i < j - 1; ) {
        		int target = -nums[i] - nums[j];
        		if(target > nums[j]) break;
            	int k = Arrays.binarySearch(nums, i+1, j, target);
            	if(k > 0) {
        			result.add(Arrays.asList(nums[i], nums[k], nums[j]));
        		}
            	
            	while(i < j - 1 && nums[j] == nums[j-1]) j--;
            	j--;
        	}
        	
        	while(i < max_j - 1 && nums[i] == nums[i+1]) i++;
        	i++;
        }
        
        return result;
        
    }
	
	public List<List<Integer>> threeSum2(int[] nums) {
		//for each i, do two-sum
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        
        for(int i = 0; i < nums.length - 2; ) {
        	int lo = i+1;
        	int hi = nums.length - 1;
        	
        	int target = -nums[i];
        	
        	while(lo < hi) {
                if(nums[lo] + nums[hi] < target) {
                	while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                	lo++;
                }
                else if(nums[lo] + nums[hi] > target) {
                	while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                	hi--;
                }
                else {
                	result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                	while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                	lo++;
                	while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                	hi--;
                }
            }
        	
        	while(i < nums.length - 2 && nums[i] == nums[i+1]) i++;
        	i++;
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int [] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//		int [] nums = {0,0,0,0};
		List<List<Integer>> result = test.threeSum2(nums);
		
		System.out.println("ok");
	}

}

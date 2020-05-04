import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceinNonIncreasingOrder {
	
	public List<Integer> minSubsequence(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        
        Arrays.parallelSort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        }
        int cur = 0;
        for(int i = nums.length-1; i >= 0; i--) {
        	res.add(nums[i]);
        	cur += nums[i];
        	if(cur > sum - cur) return res;
        }
        
        return null;
    }
	
}

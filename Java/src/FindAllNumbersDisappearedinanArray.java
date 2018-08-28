import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			int val = nums[i];
			while(nums[val-1] != val) {
				int temp = nums[val-1];
				nums[val-1] = val;
				val = temp;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1) result.add(i+1);
		}
		
		return result;
    }
}

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
	
	public int specialArray(int[] nums) {
        Arrays.parallelSort(nums);
        
        for(int i = 0; i < nums.length; i++) {
        	
        	int count = nums.length-i;
        	if(i != 0 && count <= nums[i-1]) continue;
        	if(nums[i] >= count) return count;
        }
        
        if(nums[nums.length-1] < 0) return 0;
        return -1;
    }
	
	public static void main(String[] args) {
		SpecialArrayWithXElementsGreaterThanorEqualX test = new SpecialArrayWithXElementsGreaterThanorEqualX();
		int[] nums = {3,6,7,7,0};
		System.out.print(test.specialArray(nums));
	}
}


public class CheckIfAll1sAreatLeastLengthKPlacesAway {
	
	public boolean kLengthApart(int[] nums, int k) {
        int last = Integer.MIN_VALUE / 2;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 1) {
        		int diff = i - last -1;
        		if(diff < k) return false;
        		last = i;
        	}
        }
        return true;
    }	
}

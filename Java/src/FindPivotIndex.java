
public class FindPivotIndex {
	public int pivotIndex(int[] nums) {
		if(nums.length == 0) return -1;
        int[] ltr = new int[nums.length+2];
        int[] rtl = new int[nums.length+2];
        
        for(int i = 0; i < nums.length-1; i++) {
        	ltr[i+1] = ltr[i] + nums[i];
        }
        
        for(int i = nums.length-1; i >= 0; i--) {
        	rtl[i+1] = rtl[i+2] + nums[i];
        }
        
        
        for(int i = 1; i < nums.length+1; i++) {
        	if(ltr[i-1] == rtl[i+1]) return i;
        }
        
        return -1;
    }
}

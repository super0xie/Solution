
public class LongestSubarrayof1sAfterDeletingOneElement {
	
	public int longestSubarray(int[] nums) {
        int deleted = -1;
        int l = 0;
        int res = 0;
        while(l < nums.length && nums[l] == 0) l++;
        if(l == nums.length) return 0;
        for(int i = l; i < nums.length; i++) {
        	if(nums[i] == 1) {
        		if(deleted < 0 && ((l-1 >= 0 && nums[l-1] == 0) || (i+1 < nums.length && nums[i+1] == 0)))
        			res = Math.max(res, i-l+1);
        		else
        			res = Math.max(res, i-l);
        	}else {
        		if(deleted < 0) {
        			deleted = i;
        		}else {
        			l = deleted;
        			while(l < nums.length && nums[l] == 0) l++;
        			i = l-1;
        			deleted = -1;
        		}
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		LongestSubarrayof1sAfterDeletingOneElement test = new LongestSubarrayof1sAfterDeletingOneElement();
		int[] nums = {1,1,0,0,1,1,1,0,1};
		System.out.println(test.longestSubarray(nums));
	}
}

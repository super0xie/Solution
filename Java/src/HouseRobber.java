
public class HouseRobber {
	
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		//robbed
        int [] r = new int[nums.length];
        //skipped
        int [] s = new int[nums.length];
        
        r[0] = nums[0];
        s[0] = 0;
        
        for(int i = 1; i < nums.length; i++) {
        	r[i] = s[i-1] + nums[i];
        	s[i] = Math.max(r[i-1], s[i-1]);
        }
        
        return Math.max(s[nums.length - 1], r[nums.length - 1]);
    }
	
	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int [] nums = {2,7,9,3,1};
		System.out.println(hr.rob(nums));
    }

}


public class HouseRobberII {
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int res;
        
        int[] adp = new int[nums.length];
        int[] bdp = new int[nums.length];
        
        //rob first
        adp[0] = nums[0];
        bdp[0] = nums[0];
        adp[1] = nums[0];
        bdp[1] = nums[0];
        
        for(int i = 2; i < nums.length-1; i++) {
        	adp[i] = nums[i] + bdp[i-1];
        	bdp[i] = Math.max(adp[i-1], bdp[i-1]);
        }
        
        res = Math.max(adp[nums.length-2], bdp[nums.length-2]);
        
        //skip first
        adp[0] = bdp[0] = 0;
        adp[1] = nums[1];
        bdp[1] = 0;
        
        for(int i = 2; i < nums.length; i++) {
        	adp[i] = nums[i] + bdp[i-1];
        	bdp[i] = Math.max(adp[i-1], bdp[i-1]);
        }
        res = Math.max(res, Math.max(adp[nums.length-1], bdp[nums.length-1]));
        
        return res;
    }
	
	public static void main(String[] args) {
		HouseRobberII test = new HouseRobberII();
		int[] nums = {1,2,3,1};
		test.rob(nums);
		
	}

}

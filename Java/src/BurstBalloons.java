
public class BurstBalloons {
	
    public int maxCoins(int[] oNums) {
        int [] nums = new int [oNums.length+2];
        int n = 1;
        
        for(int i = 0; i < oNums.length; i++) {
        	if(oNums[i] > 0) nums[n++] = oNums[i];
        }
        nums[n] = 1;
        nums[0] = 1;
        
        int[][] mem = new int [n+1][n+1];
        
        
        return helper(nums, 0, n, mem);
    }
    
    private int helper(int[] nums, int left, int right, int[][] mem) {
    	if(left + 1 == right) return 0;
    	if(mem[left][right] > 0) return mem[left][right];
    	
    	int res = 0;
    	for(int i = left+1; i < right; i++) {
    		res = Math.max(res, helper(nums, left, i, mem) + helper(nums, i, right, mem) + nums[i] * nums[left] * nums[right]);
    	}
    	
    	mem[left][right] = res;
    	return res;
    }
    
}

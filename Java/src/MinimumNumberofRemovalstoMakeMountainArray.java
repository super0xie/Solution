
public class MinimumNumberofRemovalstoMakeMountainArray {
	
	public int minimumMountainRemovals(int[] nums) {
		int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for(int i = 0; i < n; i++) {
        	dp1[i] = i;
        	for(int j = i-1; j >= 0; j--) {
        		if(nums[i] > nums[j])
        			dp1[i] = Math.min(dp1[i], dp1[j] + i-j-1);
        	}
        }
        
        for(int i = n-1; i >= 0; i--) {
        	dp2[i] = n-1-i;
        	for(int j = i+1; j < n; j++) {
        		if(nums[i] > nums[j])
        			dp2[i] = Math.min(dp2[i], dp2[j] + j-i-1);
        	}
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n-1; i++) {
        	res = Math.min(res, dp1[i] + dp2[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		MinimumNumberofRemovalstoMakeMountainArray test = new MinimumNumberofRemovalstoMakeMountainArray();
		int[] nums = {9,8,1,7,6,5,4,3,2,1};
		System.out.println(test.minimumMountainRemovals(nums));
	}
	
}

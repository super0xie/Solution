
public class WaystoMakeaFairArray {
	
	public int waysToMakeFair(int[] nums) {
		int n = nums.length;
        int[][] pre = new int[n][2];
        int[][] suf = new int[n][2];
        int odd = 0;
        int even = 0;
        for(int i = 0; i < n; i++) {
        	if(i % 2 == 1) even += nums[i];
        	else odd += nums[i];
        	pre[i][0] = even;
        	pre[i][1] = odd;
        }
        odd = 0;
        even = 0;
        for(int i = n-1; i >= 0; i--) {
        	if(i % 2 == 1) even += nums[i];
        	else odd += nums[i];
        	suf[i][0] = even;
        	suf[i][1] = odd;
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
        	odd = 0;
        	even = 0;
        	if(i > 0) {
        		odd += pre[i-1][0];
        		even += pre[i-1][1];
        	}
        	
        	if(i < n-1) {
        		odd += suf[i+1][1];
        		even += suf[i+1][0];
        	}
        	
        	if(odd == even) res++;
        }
        
        return res;
    }
	
}

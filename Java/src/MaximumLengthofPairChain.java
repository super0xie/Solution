import java.util.Arrays;

public class MaximumLengthofPairChain {
	
	public int findLongestChain(int[][] pairs) {
		if(pairs.length == 0) return 0;
        Arrays.sort(pairs, (a,b)->{
        	return a[0]-b[0];
        });
        
        int[] dp = new int [pairs.length];
        
        int res = 1;
        for(int i = pairs.length-1; i >= 0; i--) {
        	dp[i] = 1;
        	for(int j = i+1; j < pairs.length; j++) {
        		if(pairs[j][0] > pairs[i][1]) dp[i] = Math.max(dp[i], 1+dp[j]);
        	}
        	
        	res = Math.max(res, dp[i]);
        }
        
        return res;
    }

}

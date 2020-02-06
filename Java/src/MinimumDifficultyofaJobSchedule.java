
public class MinimumDifficultyofaJobSchedule {
	
	public int minDifficulty(int[] jd, int d) {
		int n = jd.length;
		if(n < d) return -1;
        int[][] dp = new int[n][d];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	max = Math.max(jd[i], max);
        	dp[i][0] = max;
        }
        
        for(int k = 1; k < d; k++) {
        	for(int i = k; i < n; i++) {
        		dp[i][k] = Integer.MAX_VALUE;
        		max = jd[i];
        		
        		for(int j = i-1; j >= k-1; j--) {
        			dp[i][k] = Math.min(dp[j][k-1] + max, dp[i][k]);
        			max = Math.max(max, jd[j]);
        		}
        	}
        	
        }
        
        return dp[n-1][d-1];
    }
	
	public static void main(String[] args) {
		MinimumDifficultyofaJobSchedule test = new MinimumDifficultyofaJobSchedule();
		int[] jd = {11,111,22,222,33,333,44,444};
		System.out.println(test.minDifficulty(jd, 6));
	}
	
}


public class CountSortedVowelStrings {
	
	public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for(int i = 0; i < 5; i++) dp[1][i] = 1;
        for(int i = 2; i <= n; i++) {
        	dp[i][4] = dp[i-1][4];
        	dp[i][3] = dp[i][4] + dp[i-1][3];
        	dp[i][2] = dp[i][3] + dp[i-1][2];
        	dp[i][1] = dp[i][2] + dp[i-1][1];
        	dp[i][0] = dp[i][1] + dp[i-1][0];
        }
        
        int res = dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];
        return res;
    }
	
}

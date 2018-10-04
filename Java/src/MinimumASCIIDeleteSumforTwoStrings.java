
public class MinimumASCIIDeleteSumforTwoStrings {
	
	public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int [s1.length()+1][s2.length()+1];
        
        int sum = 0;
        for(int i = 1; i <= s2.length(); i++) {
        	sum += (int)s2.charAt(i-1);
        	dp[0][i] = sum;
        }
        sum = 0;
        for(int i = 1; i <= s1.length(); i++) {
        	sum += (int)s1.charAt(i-1);
        	dp[i][0] = sum;
        }
        
        for(int i = 1; i <= s1.length(); i++) {
        	for(int j = 1; j <= s2.length(); j++) {
        		if(s1.charAt(i) == s2.charAt(i)) dp[i][j] = dp[i-1][j-1];
        		else {
        			dp[i][j] = Math.min(dp[i-1][j] + (int)s1.charAt(i), dp[i][j-1] + (int)s2.charAt(j));
        		}
        	}
        }
        
        return dp[s1.length()][s2.length()];
    }
	
}

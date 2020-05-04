
public class NumberofWaystoPaintNx3Grid {
	
	public int numOfWays(int n) {
		int mod = 1000000000+7;
        long[][] dp = new long[n+1][2];
        dp[1][0] = 6;
        dp[1][1] = 6;
        
        
        for(int i = 2; i <= n; i++) {
        	dp[i][0] = (2 * dp[i-1][1] + 2 * dp[i-1][0]) % mod;
        	dp[i][1] = (3 * dp[i-1][1] + 2 * dp[i-1][0]) % mod;
        }
        
        return (int)(dp[n][0] + dp[n][1]) % mod;
    }
	
	public static void main(String[] args) {
		NumberofWaystoPaintNx3Grid test = new NumberofWaystoPaintNx3Grid();
		System.out.println(test.numOfWays(5000));
	}
	
}

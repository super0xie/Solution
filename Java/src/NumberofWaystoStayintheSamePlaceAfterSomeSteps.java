
public class NumberofWaystoStayintheSamePlaceAfterSomeSteps {
	
	public int numWays(int steps, int arrLen) {
		if(arrLen > steps) arrLen = steps+1;
        long[][] dp = new long[steps][arrLen];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int mod = 1000000007;
        for(int i = 1; i < steps; i++) {
        	for(int j = 0; j < arrLen; j++) {
        		dp[i][j] = dp[i-1][j];
        		if(j > 0) {
        			dp[i][j] += dp[i-1][j-1];
        			dp[i][j] = dp[i][j] % mod;
        		} if(j < arrLen-1) {
        			dp[i][j] += dp[i-1][j+1];
        			dp[i][j] = dp[i][j] % mod;
        		}
        	}
        }
        
        return (int)dp[steps-1][0];
    }
	
	public static void main(String[] args) {
		NumberofWaystoStayintheSamePlaceAfterSomeSteps test = new NumberofWaystoStayintheSamePlaceAfterSomeSteps();
		System.out.println(test.numWays(430, 148488));
	}
	
}


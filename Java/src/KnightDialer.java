
public class KnightDialer {
	public int knightDialer(int N) {
		int mod = 1000000007;
		int[][] dp = new int[N][10];
		for(int i = 0; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = (dp[i-1][4] + dp[i-1][6]) % mod;
			dp[i][1] = (dp[i-1][8] + dp[i-1][6])% mod;
			dp[i][2] = (dp[i-1][7] + dp[i-1][9])% mod;
			dp[i][3] = (dp[i-1][4] + dp[i-1][8])% mod;
			dp[i][4] = ((dp[i-1][3] + dp[i-1][9])%mod + dp[i-1][0])% mod;
			dp[i][5] = 0;
			dp[i][6] = ((dp[i-1][1] + dp[i-1][7]) % mod + dp[i-1][0])% mod;
			dp[i][7] = (dp[i-1][2] + dp[i-1][6])% mod;
			dp[i][8] = (dp[i-1][1] + dp[i-1][3])% mod;
			dp[i][9] = (dp[i-1][4] + dp[i-1][2])% mod;
		}
		
		int res = 0;
		for(int i = 0; i < 10; i++) {
			res += dp[N-1][i];
			res = res % mod;
		}
		return res;
    }
	
	public static void main(String[] args) {
		KnightDialer test = new KnightDialer();
		System.out.println(test.knightDialer(161));
	}
}

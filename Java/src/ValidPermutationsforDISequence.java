
public class ValidPermutationsforDISequence {
	
	public int numPermsDISequence(String S) {
		int n = S.length()+1;
		long[][] dp = new long[n][n];
		int mod = 1_000_000_007;
		
		for(int i = 0; i < n; i++) dp[0][i] = 1;
		
		for(int i = 1; i < n; i++) {
		
			for(int j = 0; j <= n-1-i; j++) {
				if(S.charAt(i-1) == 'D') {
					for(int k = j+1; k < n; k++) {
						dp[i][j] += dp[i-1][k];
						dp[i][j] = dp[i][j] % mod;
					}
				}else {
					for(int k = j; k >= 0; k--) {
						dp[i][j] += dp[i-1][k];
						dp[i][j] = dp[i][j] % mod;
					}
				}
			}
			
		}
		
		long res = 0;
		for(int i = 0; i < n; i++) {
			res += dp[n-1][i];
			res = res % mod;
		}
		return (int)res;
    }
	
	public static void main(String[] args) {
		ValidPermutationsforDISequence test = new ValidPermutationsforDISequence();
		System.out.println(test.numPermsDISequence("DID"));
	}
	
}

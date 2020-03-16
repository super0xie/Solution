
public class MinimumInsertionStepstoMakeaStringPalindrome {
	
	public int minInsertions(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		
		for(int i = 0; i < n; i++) dp[i][i] = 0;
		
		for(int len = 2; len <= s.length(); len++) {
			for(int i = 0; i + len - 1 < s.length(); i++) {
				int j = i + len - 1;
				if(s.charAt(i) == s.charAt(j)) {
					if(i+1 > j-1) {
						dp[i][j] = 0;
					}else {
						dp[i][j] = dp[i+1][j-1];
					}
					
				}else {
					if(i+1 > j-1) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
					}
					
				}
			}
			
		}
		
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		MinimumInsertionStepstoMakeaStringPalindrome test = new MinimumInsertionStepstoMakeaStringPalindrome();
		System.out.println(test.minInsertions("g"));
	}
	
}

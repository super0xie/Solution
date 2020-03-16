
public class CountDifferentPalindromicSubsequences {
	
	public int countPalindromicSubsequences(String S) {
		int n = S.length();
		long[][][] dp = new long[n][n][4];
		int mod = 1000000007;
		for(int i = 0; i < n; i++) dp[i][i][S.charAt(i)-'a'] = 1;
		
		for(int k = 2; k <= n; k++) {
			for(int i = 0; i + k - 1 < n; i++) {
				int j = i + k - 1;
				
				if(S.charAt(i) != S.charAt(j)) {
					for(int c = 0; c < 4; c++) {
						if(c == S.charAt(i)-'a') dp[i][j][c] = dp[i][j-1][c];
						else if(c == S.charAt(j)-'a') dp[i][j][c] = dp[i+1][j][c];
						else {
							if(i+1 <= j-1)
								dp[i][j][c] = dp[i+1][j-1][c];
						}
					}
				} else {
					if(i+1 > j-1) {
						dp[i][j][S.charAt(i)-'a'] = 2;
					}else {
						for(int c = 0; c < 4; c++) {
							if(c != S.charAt(i)-'a') {
								dp[i][j][c] = dp[i+1][j-1][c];
							}else {
								dp[i][j][c] = 2;
								
								for(int cc = 0; cc < 4; cc++) {
									dp[i][j][c] += dp[i+1][j-1][cc];
									dp[i][j][c] = dp[i][j][c] % mod;
								}
							}
						}
					}
				}
			}
			
		}
		
		long res = 0;
		
		for(int i = 0; i < 4; i++) {
			res += dp[0][n-1][i];
			res = res % mod;
		}
		return (int)res;
    }
	
	public static void main(String[] args) {
		CountDifferentPalindromicSubsequences test = new CountDifferentPalindromicSubsequences();
		System.out.println(test.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
		
		
	}
	
}

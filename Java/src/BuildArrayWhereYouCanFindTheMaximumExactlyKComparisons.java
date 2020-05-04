
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
	
	public int numOfArraysSilly(int n, int m, int c) {
		int mod = 1000000007;
        long[][][] dp = new long[n+1][m+1][c+1];
        
        
        for(int k = 1; k <= c; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= m; j++) {
        			dp[i][j][k] = 0;
        			if(i < k || j < k) continue;
        			if(i == 1) {
        				dp[i][j][k] = 1;
        				continue;
        			}
        			
        			if(k == 1) {
        				dp[i][j][k] = dp[i-1][j][k] * j;
        				dp[i][j][k] = dp[i][j][k] % mod;
        				continue;
        			}

        			for(int o = 1; o <= i-1; o++){
        				for(int p = 1; p <= j-1; p++){
        					long res = dp[o][p][k-1];
        					if(res == 0) continue;
        					for(int q = 0; q < i-o-1; q++) {
        						res = res * j;
        						res = res % mod;
        					}
        					dp[i][j][k] += res;
        					dp[i][j][k] = dp[i][j][k] % mod;
        				}
        			}
        			
        		}
        	}
        	
        }
        
        int res = 0;
        for(int i = 1; i <= m; i++) {
        	res += dp[n][i][c];
        	res = res % mod;
        }
        
        return res;
    }
	
	public int numOfArrays(int n, int m, int c) {
		int mod = 1000000007;
        long[][][] dp = new long[n+1][m+1][c+1];
        
        
        for(int k = 1; k <= c; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= m; j++) {
        			dp[i][j][k] = 0;
        			if(i < k || j < k) continue;
        			if(i == 1) {
        				dp[i][j][k] = 1;
        				continue;
        			}
        			
        			if(k == 1) {
        				dp[i][j][k] = dp[i-1][j][k] * j;
        				dp[i][j][k] = dp[i][j][k] % mod;
        				continue;
        			}

        			dp[i][j][k] += dp[i-1][j][k] * j;
        			dp[i][j][k] = dp[i][j][k] % mod;
        			
        			for(int l = 1; l < j; l++) {
        				dp[i][j][k] += dp[i-1][l][k-1];
        				dp[i][j][k] = dp[i][j][k] % mod;
        			}
        			
        		}
        	}
        	
        }
        
        int res = 0;
        for(int i = 1; i <= m; i++) {
        	res += dp[n][i][c];
        	res = res % mod;
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons test = new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons();
		System.out.println(test.numOfArrays(50, 100, 25));
	}
}

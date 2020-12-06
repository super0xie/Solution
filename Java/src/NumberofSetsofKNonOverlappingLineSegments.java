
public class NumberofSetsofKNonOverlappingLineSegments {
	
	public int numberOfSetsTLE(int n, int k) {
        int mod = 1000000000+7;
        n = n-1;
        long[][] dp = new long[n][k];

        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < k; j++) {
        		if(i < j) continue;
        		else if(i == j) dp[i][j] = 1;
        		else if(j == 0) {
        			dp[i][j] = (i+2) * (i+1) / 2;
        		} else {
        			dp[i][j] = dp[i-1][j];
            		for(int l = 1; l <= i; l++) {
            			dp[i][j] += dp[i-l][j-1];
            		}
            		dp[i][j] %= mod;
        		}
        	}
        }
        
        
        return (int)dp[n-1][k-1];
    }
	
	public int numberOfSetsTLE2(int n, int k) {
        int mod = 1000000000+7;
        n = n-1;
        long[][] dp = new long[n][k];

        for(int j = 0; j < k; j++) {
        	for(int i = 0; i < n; i++) {
        		if(i < j) continue;
        		else if(i == j) dp[i][j] = 1;
        		else if(j == 0) {
        			dp[i][j] = (i+2) * (i+1) / 2;
        		} else {
        			dp[i][j] = dp[i-1][j];
            		for(int l = 1; l <= i; l++) {
            			dp[i][j] += dp[i-l][j-1];
            		}
            		dp[i][j] %= mod;
        		}
        	}
        }
        
        
        return (int)dp[n-1][k-1];
    }
	
	public int numberOfSets(int n, int k) {
		int mod = 1000000000+7;
        n = n-1;
        long[][] dp = new long[n][k];
        long[][] sum = new long[n][k];
        for(int j = 0; j < k; j++) {
        	long s = 0;
        	for(int i = 0; i < n; i++) {
        		if(i < j);
        		else if(i == j) dp[i][j] = 1;
        		else if(j == 0) {
        			dp[i][j] = (i+2) * (i+1) / 2;
        		} else {
        			dp[i][j] = dp[i-1][j];
            		dp[i][j] += sum[i-1][j-1];
            		dp[i][j] %= mod;
        		}
        		s += dp[i][j];
        		s = s % mod;
        		sum[i][j] = s;
        	}
        }
        return (int)dp[n-1][k-1];
    }
	
	public static void main(String[] args) {
		NumberofSetsofKNonOverlappingLineSegments test = new NumberofSetsofKNonOverlappingLineSegments();
		System.out.println(test.numberOfSets(3, 2));
	}
	
}

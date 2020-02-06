
public class PalindromePartitioningIII {
	
	public int palindromePartition(String s, int k) {
        int[][] cost = new int[s.length()][s.length()];
        
        for(int l = 2; l <= s.length(); l++) {
        	for(int i = 0; i + l - 1 < s.length(); i++) {
        		int j = i + l - 1;
        		if(s.charAt(i) == s.charAt(j)) {
        			if(l == 2) cost[i][j] = 0;
        			else cost[i][j] = cost[i+1][j-1];
        		}else {
        			if(l == 2) cost[i][j] = 1;
        			else cost[i][j] = cost[i+1][j-1]+1;
        		}
        	}
        }
        
        
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[s.length()][k];
        for(int j = 0; j < k; j++) {
        	for(int i = 0; i < s.length(); i++) {
        		if(j == 0) dp[i][j] = cost[0][i];
        		else {
        			if(i < j) dp[i][j] = max;
        			else if(i == j) dp[i][j] = 0;
        			else {
        				dp[i][j] = max;
        				for(int l = i; l > 0; l--) {
        					if(dp[l-1][j-1] == max) break;
        					dp[i][j] = Math.min(dp[i][j], cost[l][i] + dp[l-1][j-1]);
        				}
        			}
        		}
        	}
        }
        
        return dp[s.length()-1][k-1];
    }
	
	public static void main(String[] args) {
		PalindromePartitioningIII test = new PalindromePartitioningIII();
		System.out.println(test.palindromePartition("aabbc", 3));
	}
	
}

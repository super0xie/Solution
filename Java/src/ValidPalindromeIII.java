
public class ValidPalindromeIII {
	
	public boolean isValidPalindrome(String s, int k) {
		int[][] dp = new int [s.length()][s.length()];
        
        for(int i = s.length()-1; i >= 0; i--) {
        	for(int j = i; j < s.length(); j++) {
        		if(j == i) {
        			dp[i][j] = 1;
        		}else {
        			if(s.charAt(i) == s.charAt(j)) {
        				if(i+1 <= j-1) {
        					dp[i][j] = dp[i+1][j-1] + 2;
        				}else {
        					dp[i][j] = 2;
        				}
        			}else {
        				dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        			}
        		}
        	}
        }
        
        if(dp[0][s.length()-1] < s.length()-k) return false;
        return true;
    }
	
}

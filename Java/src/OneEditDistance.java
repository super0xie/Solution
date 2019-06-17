
public class OneEditDistance {
	
	public boolean isOneEditDistanceOld(String s, String t) {
        if(s.length() != t.length()) {
        	if(Math.abs(s.length() - t.length()) > 1) return false;
        	
        	int count = 0;
        	int i = 0;
        	int j = 0;
        	
        	while(i < s.length() && j < t.length()) {
        		if(s.charAt(i) == t.charAt(j)) {
        			i++;
        			j++;
        		}else {
        			count++;
        			if(count > 1) return false;
        			if(s.length() > t.length()) i++;
        			else j++;
        		}
        	}
        	
        	return true;
        }else {
        	int count = 0;
        	for(int i = 0; i < s.length(); i++) {
        		if(s.charAt(i) != t.charAt(i)) count++;
        	}
        	if(count == 1) return true;
        	return false;
        }
    }
	
	public boolean isOneEditDistance(String s, String t) {
        int[][] dp = new int [s.length()+1][t.length()+1];
        dp[0][0] = 0;
        for(int i = 0; i <= s.length(); i++) dp[i][0] = i;
        for(int j = 0; j <= t.length(); j++) dp[0][j] = j;
        
        for(int i = 1; i <= s.length(); i++) {
        	for(int j = 1; j <= t.length(); j++) {
        		if(s.charAt(i-1) == t.charAt(j-1)) {
        			dp[i][j] = dp[i-1][j-1];
        		}else {
        			int res = Integer.MAX_VALUE;
        			res = Math.min(res, dp[i-1][j-1] + 1);
        			res = Math.min(res, dp[i][j-1] + 1);
        			res = Math.min(res, dp[i-1][j] + 1);
        			dp[i][j] = res;
        		}
        	}
        }
        
        return dp[s.length()][t.length()] == 1;
    }
	
	public static void main(String[] args) {
		OneEditDistance test = new OneEditDistance();
		System.out.println(test.isOneEditDistance("1203", "1213"));
		
	}

}


public class MinimumDistancetoTypeaWordUsingTwoFingers {
	
	
	public int minimumDistance(String word) {
		int n = word.length();
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 2; i <= n; i++) {
        	for(int j = 0; j < i; j++) {
        		if(j == i-1) {
        			dp[i][j] = Integer.MAX_VALUE;
        			for(int k = 0; k < j; k++) {
        				if(k == 0)
        					dp[i][j] = Math.min(dp[i][j], dp[j][k]);
        				else
        					dp[i][j] = Math.min(dp[i][j], dp[j][k] + dis(word.charAt(i-1), word.charAt(k-1)));
        			}
        			
        		}else {
        			dp[i][j] = dp[i-1][j] + dis(word.charAt(i-1), word.charAt(i-2));
        		}	
        	}
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) res = Math.min(res, dp[n][i]);
        return res;
    }
	
	private int dis(char a, char b) {
		int ia = (int)(a-'A');
		int ib = (int)(b-'A');
		
		return Math.abs(ia/6 - ib/6) + Math.abs(ia%6 - ib%6);
	}
	
	public static void main(String[] args) {
		MinimumDistancetoTypeaWordUsingTwoFingers test = new MinimumDistancetoTypeaWordUsingTwoFingers();
		System.out.println(test.minimumDistance("NEW"));
	}
	
}

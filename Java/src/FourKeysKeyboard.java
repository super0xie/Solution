
public class FourKeysKeyboard {
	
	public int maxA(int N) {
        int [] dp = new int [N+1];
        
        for(int i = 1; i < N+1; i++) {
        	dp[i] = dp[i-1] + 1;
        	for(int j = 1; j < i-1; j++) {
        		dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
        	}
        }
        return dp[N];
    }

}

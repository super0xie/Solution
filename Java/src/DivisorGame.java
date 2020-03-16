
public class DivisorGame {
	
	public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        for(int i = 2; i <= N; i++) {
        	for(int j = 1; j < i; j++) {
        		if(i % j == 0 && !dp[i-j]) {
        			dp[i] = true;
        		}
        	}
        }
        return dp[N];
    }
	
}

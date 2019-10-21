
public class DiceRollSimulation {
	
	
	
	public int dieSimulator(int n, int[] rollMax) {
		long mod = 1000000000 + 7;
		long[][] dp = new long[n][6];
		for(int i = 0; i < 6; i++) dp[0][i] = 1;
		long sum = 6;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 6; j++) {
				dp[i][j] = sum;
				int idx = i - rollMax[j];
				if(idx >= 0) {
					if(idx == 0) {
						dp[i][j] -= 1;
						if(dp[i][j] < 0) dp[i][j] += mod;
					} else {
						for(int k = 0; k < 6; k++) {
							if(k != j) {
								dp[i][j] -= dp[idx-1][k];
								if(dp[i][j] < 0) dp[i][j] += mod;
							}
								
						}
					}
				}
			}
			
			sum = 0;
			for(int j = 0; j < 6; j++) {
				sum += dp[i][j];
				sum = sum % mod;
			}
			
		}
		
		
		int res = 0;
		for(int i = 0; i < 6; i++) {
			res += dp[n-1][i];
			res = (int) (res % mod);
		}
		
		return res;
    }
	
	
	public static void main(String[] args) {
		DiceRollSimulation test = new DiceRollSimulation();
		System.out.println(test.dieSimulator(20, new int[]{8,5,10,8,7,2}));
	}
	
}


public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if(amount == 0) return 0;
		
		int [] dp = new int [amount+1];
		for(int i : coins) {
			if(i <= amount) dp[i] = 1;
		}
		
		for(int i = 1; i <= amount; i++) {
			if(dp[i] != 0) continue;
			int min = Integer.MAX_VALUE;
			for(int j : coins) {
				if(i - j > 0 && dp[i-j] != 0) {
					if(dp[i - j] < min) {
						min = dp[i-j];
					}
				}
			}
			if(min != Integer.MAX_VALUE) dp[i] = min + 1;
		}
		
		if(dp[amount] == 0) return -1;
		else return dp[amount];
        
    }
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] coins = {1, 2, 5};
		System.out.println(cc.coinChange(coins, 11));
	}

}

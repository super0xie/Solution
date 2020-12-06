
public class CountAllPossibleRoutes {
	
	public int countRoutes(int[] locations, int start, int finish, int fuel) {
		int n = locations.length;
		int mod = 1000000000+7;
        long[][] dp = new long[n][fuel+1];
        dp[finish][0] = 1;
        for(int k = 1; k <= fuel; k++) {
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(i == j) continue;
        			int cost = Math.abs(locations[i]-locations[j]);
        			if(k - cost < 0) continue;
        			dp[i][k] += dp[j][k-cost];
        			dp[i][k] = dp[i][k] % mod;
        		}
        	}
        }
        int res = 0;
        for(int k = 0; k <= fuel; k++) {
        	res += dp[start][k];
        	res = res % mod;
        }
        return res;
    }
	
	public static void main(String[] args) {
		CountAllPossibleRoutes test = new CountAllPossibleRoutes();
		int[] locations = {1,2,3};
		int start = 0, finish = 2, fuel = 40;
		test.countRoutes(locations, start, finish, fuel);
	}
	
}

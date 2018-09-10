


class PaintHouseII{
	
	public int minCostII(int[][] costs) {
		if(costs.length == 0) return 0;
		int n = costs.length;
		int k = costs[0].length;
		int[][] dp = new int [n][k];
		
		int min = Integer.MAX_VALUE;
		int minInd = 0;
		int secMin = Integer.MAX_VALUE;

		for(int j = 0; j < k; j++) {
			dp[0][j] = costs[0][j];
			if(dp[0][j] < min) {
				secMin = min;
				min = dp[0][j];
				minInd = j;
			}else if(dp[0][j] >= min && dp[0][j] < secMin) {
				secMin = dp[0][j];
			}
		}
		
		for(int i = 1; i < n; i++) {
			int curmin = Integer.MAX_VALUE;
			int curminInd = 0;
			int cursecMin = Integer.MAX_VALUE;
			
			for(int j = 0; j < k; j++) {
				if(j == minInd) {
					dp[i][j] = secMin + costs[i][j];
				}else {
					dp[i][j] = min + costs[i][j];
				}
				
				if(dp[i][j] < curmin) {
					cursecMin = curmin;
					curmin = dp[i][j];
					curminInd = j;
				}else if(dp[i][j] >= curmin && dp[i][j] < cursecMin) {
					cursecMin = dp[i][j];
				}
			}
			
			min = curmin;
			minInd = curminInd;
			secMin = cursecMin;
		}
		
		int res = Integer.MAX_VALUE;
		for(int j = 0; j < k; j++) {
			res = Math.min(res, dp[n-1][j]);
		}
		
		return res;
    }
	
   
    


	public static void main(String[] args){
		int[][] costs = {{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}};
		PaintHouseII test = new PaintHouseII();
		
		test.minCostII(costs);
    
	}

}

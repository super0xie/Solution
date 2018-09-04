
public class BestTimetoBuyandSellStockIV {
	
    public int maxProfit(int k, int[] prices) {
    	if(prices.length == 0 || k == 0) return 0;
    	int row = k > (prices.length / 2) ? (prices.length / 2) * 2 : 2*k; 
    	if(row <= 0) return 0;
    	int[][] dp = new int[row][2];
    	
    	dp[0][0] = -prices[0];
    	for(int i = 2; i < row; i = i + 2) {
    		dp[i][0] = Integer.MIN_VALUE;
    	}
    	
    	int cur = 0;
    	int pre = 0;
    	for(int i = 1; i < prices.length; i++) {
    		if(i % 2 == 0) {
    			cur = 0;
    			pre = 1;
    		}else {
    			cur = 1;
    			pre = 0;
    		}
    		dp[0][cur] = Math.max(dp[0][pre], -prices[i]);
    		for(int j = 1; j < row; j = j + 2) {
    			dp[j][cur] = Math.max(dp[j][pre], dp[j-1][pre] + prices[i]);
    		}
    		for(int j = 2; j < row; j = j + 2) {
    			dp[j][cur] = Math.max(dp[j][pre], dp[j-1][pre] - prices[i]);
    		}
    	}
    	
    	int res = 0;
    	for(int j = 1; j < row; j = j + 2) {
			res = Math.max(res, dp[j][cur]);
		}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] prices = {3,2,6,5,0,3};
    	BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
    	System.out.println(test.maxProfit(2, prices));
    }

}

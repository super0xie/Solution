
public class BestTimetoBuyandSellStockwithTransactionFee {
	
	public int maxProfitOld(int[] prices, int fee) {
		if(prices.length == 0) return 0;
        int[] dpHaveStock = new int [prices.length];
        int[] dpNoStock = new int [prices.length];
        
        dpHaveStock[0] = -prices[0];
        dpNoStock[0] = 0;
        
        for(int i = 1; i < prices.length; i++) {
        	dpNoStock[i] = Math.max(dpNoStock[i-1], dpHaveStock[i-1] - fee + prices[i]);
        	dpHaveStock[i] = Math.max(dpHaveStock[i-1], dpNoStock[i-1] - prices[i]);
        }
        
        return dpNoStock[prices.length-1];
        
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return dp[prices.length-1][1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        BestTimetoBuyandSellStockwithTransactionFee test = new BestTimetoBuyandSellStockwithTransactionFee();
        System.out.print(test.maxProfit(prices, 2));
    }

}

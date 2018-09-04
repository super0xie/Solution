
public class BestTimetoBuyandSellStockwithTransactionFee {
	
	public int maxProfit(int[] prices, int fee) {
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

}

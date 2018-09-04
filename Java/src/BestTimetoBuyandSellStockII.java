
public class BestTimetoBuyandSellStockII {
	
	public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
        int[] dpHaveStock = new int [prices.length];
        int[] dpNoStock = new int [prices.length];
        
        
        dpHaveStock[0] = -prices[0];
        dpNoStock[0] = 0;
        
        int res = 0;
        for(int i = 1; i < prices.length ; i++) {
        	dpHaveStock[i] = Math.max(dpNoStock[i-1] - prices[i], dpHaveStock[i-1]);
        	dpNoStock[i] = Math.max(dpNoStock[i-1], dpHaveStock[i-1] + prices[i]);
        	
        	res = Math.max(dpNoStock[i], res);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
		int[] prices = {1,2,3,4,5};
		test.maxProfit(prices);
	}

}

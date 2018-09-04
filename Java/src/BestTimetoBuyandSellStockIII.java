
public class BestTimetoBuyandSellStockIII {
	
    public int maxProfit(int[] prices) {
    	if(prices.length == 0) return 0;
        int[] have1stStock = new int[prices.length];
        int[] have2ndStock = new int[prices.length];
        int[] NoStock1st = new int[prices.length];
        int[] NoStock2nd = new int[prices.length];
        
        have1stStock[0] = -prices[0];
        have2ndStock[0] = Integer.MIN_VALUE;
        
        for(int i = 1; i < prices.length; i++) {
        	have1stStock[i] = Math.max(have1stStock[i-1], -prices[i]);
        	NoStock1st[i] = Math.max(NoStock1st[i-1], have1stStock[i-1] + prices[i]);
        	have2ndStock[i] = Math.max(have2ndStock[i-1], NoStock1st[i-1] - prices[i]);
        	NoStock2nd[i] = Math.max(NoStock2nd[i-1], have2ndStock[i-1]+prices[i]);
        }
        
        return Math.max(NoStock1st[prices.length-1], NoStock2nd[prices.length-1]);
    }
    
    public static void main(String[] args) {
    	int[] prices = {1,2,3,4,5};
    	BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
    	System.out.println(test.maxProfit(prices));
    }
    
}


public class BestTimetoBuyandSellStockwithCooldown {
	
	public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		int[] dpHaveStock = new int[prices.length];
		int[] dpNoStock = new int[prices.length];
		int[] dpCoolDown = new int[prices.length];
		
		dpHaveStock[0] = -prices[0];
		dpNoStock[0] = 0;
		dpCoolDown[0] = 0;
		
		for(int i = 1; i < prices.length; i++) {
			dpHaveStock[i] = Math.max(dpNoStock[i-1] - prices[i], dpHaveStock[i-1]);
			dpCoolDown[i] = dpHaveStock[i-1] + prices[i];
			dpNoStock[i] = Math.max(dpCoolDown[i-1], dpNoStock[i-1]);
		}
		
		return Math.max(dpNoStock[prices.length-1], dpCoolDown[prices.length-1]);
    }
	
	public static void main(String[] args) {
		BestTimetoBuyandSellStockwithCooldown test = new BestTimetoBuyandSellStockwithCooldown();
		int[] prices = {1,2,3,0,2};
		System.out.println(test.maxProfit(prices));
	}

}

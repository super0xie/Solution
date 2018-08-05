
public class BestTimeToBuyAndSellStock {
	//[7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
    	
    	if(prices == null || prices.length == 0) return 0;
    	
        int minPrice = prices[0];
        int profit = 0;
        
        for(int i = 0; i < prices.length; i++) {
        	if(prices[i] - minPrice > profit) profit = prices[i] - minPrice;
        	if(prices[i] < minPrice) minPrice = prices[i];
        }
        
        return profit;
        
    }
    
    public static void main(String[] args) {
    	BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
		int[] prices = {7,6,4,3,1};
		System.out.println(test.maxProfit(prices));
	}
}

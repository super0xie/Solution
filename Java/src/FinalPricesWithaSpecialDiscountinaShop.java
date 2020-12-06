import java.util.Stack;

public class FinalPricesWithaSpecialDiscountinaShop {
	
	public int[] finalPricesOn2(int[] prices) {
		for(int i = 0; i < prices.length; i++) {
			for(int j = i+1; j < prices.length; j++) {
				if(prices[j] < prices[i]) {
					prices[i] -= prices[j];
					break;
				}
			}
		}
		
        return prices;
    }
	
	public int[] finalPrices(int[] prices) {
		Stack<Integer> s = new Stack<>();
		for(int i = prices.length-1; i >= 0; i--) {
			while(!s.isEmpty() && s.peek() > prices[i]) s.pop();
			int n = prices[i];
			if(!s.isEmpty()) prices[i] -= s.peek();
			s.push(n);
		}
        return prices;
    }
	
}

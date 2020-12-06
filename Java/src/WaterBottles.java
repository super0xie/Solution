
public class WaterBottles {
	public int numWaterBottles(int numBottles, int numExchange) {
        int b = numBottles;
        int res = numBottles;
        
        while(b >= numExchange) {       	
        	int w = b / numExchange;
        	res += w;
        	b -= w * numExchange;
        	b += w;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		WaterBottles test = new WaterBottles();
		test.numWaterBottles(9, 3);
	}
}

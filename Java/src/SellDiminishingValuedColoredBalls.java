import java.util.TreeMap;

public class SellDiminishingValuedColoredBalls {
	
	public int maxProfit(int[] inventory, int orders) {
        long sum = 0;
        int mod = 1_000_000_000+7;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : inventory) {
        	map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        while(orders > 0) {
        	int first = map.lastKey();
        	int count = map.get(first);
        	
        	Integer second = map.floorKey(first-1);
        	if(second == null) second = 0;
        	
        	long maxToSell = (long)count * (first-second);
        	if(maxToSell >= orders) {
        		long eachSell = orders / count;
        		long rest = orders % count;
        		long target = first - eachSell;
        		sum += target * rest;
        		sum += (long)count * (first + target + 1) * (first-target) / 2;
        		orders = 0;
        	}else {
        		sum += (long)count * (first + second+1) * (first-second) / 2;
        		map.put(second, map.get(second)+count);
        		map.remove(first);
        		orders -= maxToSell;
        	}
        }
        
        return (int)(sum % mod);
    }
	
	public static void main(String[ ]args) {
		SellDiminishingValuedColoredBalls test = new SellDiminishingValuedColoredBalls();
		int[] inventory = {497978859,167261111,483575207,591815159};
		System.out.println(test.maxProfit(inventory, 836556809));
	}
	
}

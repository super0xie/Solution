import java.util.HashMap;

public class MinimizeRoundingErrortoMeetTarget {
	
	public String minimizeError(String[] prices, int target) {
        HashMap<Integer, Double> map = new HashMap<>();
        map.put(0, 0.0);

        for(int i = 0; i < prices.length; i++){
            HashMap<Integer, Double> cur = new HashMap<>();
            double d = Double.parseDouble(prices[i]);
            double floor = Math.floor(d);
            double floorError = Math.abs(floor - d);
            double ceil = Math.ceil(d);
            double ceilError = Math.abs(ceil - d);

            for(int key : map.keySet()){
                int n  = key + (int)floor;
                cur.put(n, Math.min(cur.getOrDefault(n, Double.MAX_VALUE), map.get(key) + floorError));
                n = key + (int)ceil;
                cur.put(n, Math.min(cur.getOrDefault(n, Double.MAX_VALUE), map.get(key) + ceilError));
            }

            map = cur;
        }

        if(map.containsKey(target)){
            double d = map.get(target);
            String res = String.format("%.3f", d);
            return res;
        }else{
            return "-1";
        }
        
    }

    public static void main(String[] args) {
        MinimizeRoundingErrortoMeetTarget test = new MinimizeRoundingErrortoMeetTarget();
        String[] prices = {"1.500","2.500","3.500"};
        System.out.println(test.minimizeError(prices, 10));
    }
	
	
	
}

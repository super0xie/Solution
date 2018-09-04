import java.util.HashMap;

public class RabbitsinForest {
	
	public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : answers) {
        	map.merge(i, 1, Integer::sum);
        }
        
        int res = 0;
        
        for(int i : map.keySet()) {
        	int count = map.get(i);
        	res += ((count-1) / (i+1)) * (i+1) + i+1;
        }
        return res;
    }
	
}

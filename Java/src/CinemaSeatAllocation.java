import java.util.ArrayList;
import java.util.HashMap;

public class CinemaSeatAllocation {
	
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int res = 2 * n;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] r : reservedSeats) {
        	if(!map.containsKey(r[0])) map.put(r[0], new ArrayList<>());
        	map.get(r[0]).add(r[1]);
        }
        
        for(int key : map.keySet()) {
        	boolean left = true;
        	boolean right = true;
        	boolean center = true;
        	for(int i : map.get(key)) {
        		if(i >=2 && i <= 5) left = false;
        		if(i >=6 && i <= 9) right = false;
        		if(i >= 4 && i <= 7) center = false;
        	}
        	
        	if(left && right) continue;
        	else if(left || right) res--;
        	else if(center) res--;
        	else res -= 2;
        	
        }
        
        return res;
        
    }
	
}

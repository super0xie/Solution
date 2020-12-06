import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LeastNumberofUniqueIntegersafterKRemovals {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr) 
        	map.put(i, map.getOrDefault(i, 0)+1);
        
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : map.keySet()) {
        	l.add(map.get(i));
        }
        
        Collections.sort(l);
        int i = 0;
        for(; i < l.size(); i++) {
        	if(k >= l.get(i)) {
        		k -= l.get(i);
        	}else {
        		break;
        	}
        }
        
        return l.size()-i;
    }
	
	public static void main(String[] args){
		LeastNumberofUniqueIntegersafterKRemovals test = new LeastNumberofUniqueIntegersafterKRemovals();
		test.findLeastNumOfUniqueInts(new int[] {5, 5, 4}, 1);
	}
}

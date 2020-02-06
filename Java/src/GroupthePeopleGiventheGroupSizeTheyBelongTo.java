import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
	
	public List<List<Integer>> groupThePeople(int[] sizes) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < sizes.length; i++) {
        	if(!map.containsKey(sizes[i])) map.put(sizes[i], new ArrayList<>());
        	map.get(sizes[i]).add(i);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int key : map.keySet()) {
        	ArrayList<Integer> l = map.get(key);
        	
        	List<Integer> cur = null;
        	for(int i = 0; i < l.size(); i++) {
        		if(i % key == 0) {
        			cur = new ArrayList<>();
        			res.add(cur);
        		}
        		cur.add(l.get(i));
        	}
        	
        }
        
        return res;
        
    }
	
}

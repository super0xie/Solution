import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class KeysandRooms {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if(rooms.size() == 1) return true;
        HashSet<Integer> keySet = new HashSet<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
		
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()) {
        	int polled = queue.poll();
        	
        	List<Integer> keys = rooms.get(polled);
        	
        	
        	for(int key : keys) {
        		if(key != 0)
        			keySet.add(key);
            	if(keySet.size() == rooms.size()-1) return true;
        		keySet.add(key);
        		if(!visited.contains(key)) {
        			queue.add(key);
        			visited.add(key);
        		}
        	}
        	
        	
        }
		return false;
    }
}

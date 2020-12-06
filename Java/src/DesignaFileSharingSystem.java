import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DesignaFileSharingSystem {
	
	public void FileSharing(int m) {
        
    }
	
	private boolean[] idUsed = new boolean[10001];
	private HashMap<Integer, HashSet<Integer>> chunks = new HashMap<>();
	private HashMap<Integer, List<Integer>> users = new HashMap<>();

    public int join(List<Integer> ownedChunks) {
    	int i = 1;
        for(; i < idUsed.length; i++) 
        	if(!idUsed[i]) break;
        idUsed[i] = true;
        for(int j : ownedChunks) {
        	if(!chunks.containsKey(j)) chunks.put(j, new HashSet<>());
        	chunks.get(j).add(i);
        }
        users.put(i, ownedChunks);
        return i;
    }
    
    public void leave(int userID) {
        List<Integer> c = users.get(userID);
        for(int i : c) 
        	chunks.get(i).remove(userID);
        users.remove(userID);
        idUsed[userID] = false;
    }
    
    public List<Integer> request(int userID, int chunkID) {
    	List<Integer> res = new ArrayList<>();
    	if(!chunks.containsKey(chunkID)) return res;
    	
    	for(int u : chunks.get(chunkID)) 
    		res.add(u);
    	
    	if(!res.isEmpty()) {
    		users.get(userID).add(chunkID);
    		chunks.get(chunkID).add(userID);
    	}
    	
    	Collections.sort(res);
    	return res;
    }
}

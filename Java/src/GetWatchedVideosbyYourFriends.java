import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GetWatchedVideosbyYourFriends {
	
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
		int n = friends.length;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        int cur = 1;
        while(!q.isEmpty()) {
        	LinkedList<Integer> aux = new LinkedList<>();
        	while(!q.isEmpty()) {
        		int p = q.poll();
        		
        		for(int f : friends[p]) {
        			if(!visited[f]) {
        				visited[f] = true;
        				aux.add(f);
        			}
        		}
        	}
        	q = aux;
        	if(cur == level) break;
        	cur++;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i : q) {
        	for(String v : watchedVideos.get(i)) {
        		map.put(v, map.getOrDefault(v, 0)+1);
        	}
        }
        
        List<String> res = new ArrayList<>();
        for(String key : map.keySet())
        	res.add(key);
        
        Collections.sort(res, (a, b)->{
        	if(map.get(a) != map.get(b)) {
        		return map.get(a) - map.get(b);
        	}else {
        		return a.compareTo(b);
        	}
        });
        
        return res;
    }
	
}

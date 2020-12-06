import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class FindServersThatHandledMostNumberofRequests {
	
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		int[] count = new int[k];
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        TreeSet<Integer> pq = new TreeSet<>();
        for(int i = 0; i < k; i++) {
        	pq.add(i);
        }
        
        for(int i = 0; i < arrival.length; i++) {
        	ArrayList<Integer> toRemove = new ArrayList<>();
        	for(int key : map.headMap(arrival[i], true).keySet()) {
        		toRemove.add(key);
        	}
        	
        	for(int j : toRemove) {
        		for(int servers : map.get(j)) {
        			pq.add(servers);
        		}
        		map.remove(j);
        	}
        	
        	if(pq.isEmpty()) continue;
        	int mod = i % k;
        	int s = 0;
        	if(pq.contains(mod)) s = mod;
        	else {
        		Integer aux = pq.ceiling(mod+1);
        		if(aux == null) s = pq.first();
        		else s = aux;
        	}
        	pq.remove(s);
        	count[s]++;
        	int end = arrival[i] + load[i];
        	if(!map.containsKey(end)) map.put(end, new ArrayList<>());
        	map.get(end).add(s);
        }
        
        List<Integer> res = new ArrayList<>();
        int max = -1;
        for(int i = 0; i < k; i++) {
        	if(count[i] > max) {
        		max = count[i];
        		res.clear();
        		res.add(i);
        	}else if(count[i] == max) {
        		res.add(i);
        	}
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		FindServersThatHandledMostNumberofRequests test = new FindServersThatHandledMostNumberofRequests();
		int[] arrival = {1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32};
		int[] load = {9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6};
		List<Integer> res = test.busiestServers(7, arrival, load);
		for(int i : res) System.out.print(i + ", ");
	}
}

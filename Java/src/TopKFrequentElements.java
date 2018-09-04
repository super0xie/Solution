import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements{
	
	private class Pair implements Comparable<Pair>{
		int v;
		int c;
		
		Pair(int v, int c){
			this.v = v;
			this.c = c;
		}
		
		@Override
		public int compareTo(Pair other) {
			return other.c - c;
		}
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
        	map.merge(i, 1, Integer::sum);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); 
        for(int key : map.keySet()) {
        	pq.add(new Pair(key, map.get(key)));
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
        	res.add(pq.poll().v);
        }
        return res;
        
    }

}

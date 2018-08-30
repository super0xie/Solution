import java.util.LinkedList;

public class DesignHitCounter {
	LinkedList<Integer> list;
	
	
	public void HitCounter() {
        list = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while(!list.isEmpty() && timestamp - list.getFirst() >= 300) {
        	list.removeFirst();
        }
        
        list.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	while(!list.isEmpty() && timestamp - list.getFirst() >= 300) {
        	list.removeFirst();
        }
        
        return list.size();
    }

}


import java.util.PriorityQueue;

public class HandofStraights {
	public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : hand) {
        	pq.add(i);
        }
        
        
        while(!pq.isEmpty()) {
        	int start = pq.poll();
        	for(int i = start+1; i < start + W; i++) {
        		if(!pq.remove(i)) return false;
        	}
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		HandofStraights test = new HandofStraights();
		int[] hand = {1,2,3,4,5,6};
				
		test.isNStraightHand(hand, 2);
		
		
	}
}

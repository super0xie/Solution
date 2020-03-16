import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {return b-a;});
		for(int i : stones) pq.add(i);
		
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			if(a != b) pq.add(Math.abs(a-b));
		}
		
		if(pq.isEmpty()) return 0;
		else return pq.poll();
    }
	
}

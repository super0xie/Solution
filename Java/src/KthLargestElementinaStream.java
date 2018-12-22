import java.util.PriorityQueue;

public class KthLargestElementinaStream {
	
	private int k;
	private PriorityQueue<Integer> pq;
	public void KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i : nums) {
        	add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}

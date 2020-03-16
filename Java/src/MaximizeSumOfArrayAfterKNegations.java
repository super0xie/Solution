import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
	
	public int largestSumAfterKNegations(int[] A, int K) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : A) {
        	pq.add(i);
        }
        
        while(K > 0) {
        	int i = pq.poll();
        	i = -i;
        	pq.add(i);
        	K--;
        }
        
        for(int i : pq) {
        	res += i;
        }
        
        return res;
    }
	
}

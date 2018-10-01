import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
	
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        int cur = startFuel;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{
        	return b-a;
        });
        while(cur < target) {
        	for(; i < stations.length && stations[i][0] <= cur; i++) {
        		pq.add(stations[i][1]);
        	}
        	if(pq.isEmpty()) return -1;
        	else {
        		cur += pq.poll();
        		res++;
        	}
        }
        
        return res;
    }
	
}

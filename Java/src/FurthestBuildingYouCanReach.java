import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
	
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        int i = 0;
        for(; i < heights.length-1; i++) {
        	if(heights[i] >= heights[i+1]) continue;
        	int diff = heights[i+1]-heights[i];
        	if(pq.size() < ladders) {
        		pq.add(diff);
        	}else {
        		if(pq.isEmpty()) {
        			sum += diff;
        		}else {
        			if(diff > pq.peek()) {
        				sum += pq.poll();
        				pq.add(diff);
        			}else {
        				sum += diff;
        			}
        		}
        		
        		if(sum > bricks) break;
        	}
        }
        
        return i;
    }
	
}

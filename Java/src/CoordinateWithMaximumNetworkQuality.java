import java.util.Arrays;

public class CoordinateWithMaximumNetworkQuality {
	
	public int[] bestCoordinate(int[][] towers, int radius) {
		int max = Integer.MIN_VALUE;
		int[] res = null;
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
		for(int[] t : towers) {
			maxX = Math.max(maxX, t[0]);
			minX = Math.min(minX, t[0]);
			maxY = Math.max(maxY, t[1]);
			minY = Math.min(minY, t[1]);
		}
		
        for(int i = minX; i <= maxX; i++) {
        	for(int j = minY; j <= maxY; j++) {
        		int sum = 0;
        		for(int[] t : towers) {
        			double dis = Math.sqrt((t[0]-i)*(t[0]-i) + (t[1]-j)*(t[1]-j));
        			if(dis <= radius)
        				sum += Math.floor((double)t[2] / (1+dis));
        		}
        		if(sum > max) {
        			max = sum;
        			res = new int[] {i, j};
        		}
        	}
        }
        if(max == 0) return new int[] {0, 0};
        return res;
    }
	
//	public int[] bestCoordinate(int[][] towers, int radius) {
//		int max = Integer.MIN_VALUE;
//		int[] res = null;
//        Arrays.parallelSort(towers, (a, b)->{
//        	if(a[0] != b[0]) return a[0]-b[0];
//        	return a[1]-b[1];
//        });
//		
//        for(int[] p : towers) {
//        	int i = p[0];
//        	int j = p[1];
//        	int sum = 0;
//    		for(int[] t : towers) {
//    			double dis = Math.sqrt((t[0]-i)*(t[0]-i) + (t[1]-j)*(t[1]-j));
//    			if(dis <= radius)
//    				sum += Math.floor((double)t[2] / (1+dis));
//    		}
//    		if(sum > max) {
//    			max = sum;
//    			res = new int[] {i, j};
//    		}
//        }
//        
//        if(max == 0) return new int[] {0, 0};
//        return res;
//    }
	
	public static void main(String[] args) {
		CoordinateWithMaximumNetworkQuality test = new CoordinateWithMaximumNetworkQuality();
		int[][] towers = {{2,1,9},{0,1,9}};
		test.bestCoordinate(towers, 2);
	}
	
	
}

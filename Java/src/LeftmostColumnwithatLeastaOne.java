import java.util.List;

public class LeftmostColumnwithatLeastaOne {
	
	interface BinaryMatrix {
		 public int get(int row, int col);
		 public List<Integer> dimensions();
	};
	
	public int leftMostColumnWithOne(BinaryMatrix bm) {
        List<Integer> dim = bm.dimensions();
        int m = dim.get(0);
        int n = dim.get(1);
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++) {
        	int l = 0;
        	int r = n-1;
        	
        	while(l < r) {
        		int mid = l + (r-l)/2;
        		int v = bm.get(i, mid);
        		if(v == 0) l = mid+1;
        		else r = mid;
        	}
        	if(bm.get(i, l) == 1) min = Math.min(min, l);
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
	
}

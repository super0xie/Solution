import java.util.ArrayList;

public class NumberofShipsinaRectangle {

//	interface Sea {
//		public boolean hasShips(int[] topRight, int[] bottomLeft);
//	}
	
	class Sea {
		public boolean hasShips(int[] topRight, int[] bottomLeft) {
			return false;
		}
	}
	
	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0];
        int y1 = bottomLeft[1];
        int x2 = topRight[0];
        int y2 = topRight[1];
        
        
        ArrayList<Integer> cols = new ArrayList<>();
        int x = x1;
        while(x <= x2) {
        	int l = x;
        	int r = x2;
        	
        	while(l < r) {
        		int mid = l + (r-l)/2;
        		boolean res = sea.hasShips(new int[] {mid, y2}, new int[] {l, y1});
        		if(res) r = mid;
        		else l = mid+1;
        	}
        	
        	if(sea.hasShips(new int[] {l, y2}, new int[] {l, y1})) cols.add(l);
        	x = l+1;
        }
        
        int res = 0;
        
        for(int col : cols) {
        	int y = y1;
        	while(y <= y2) {
        		int l = y;
        		int r = y2;
        		
        		while(l < r) {
        			int mid = l + (r-l)/2;
        			boolean ret = sea.hasShips(new int[] {col, mid}, new int[] {col, l});
            		if(ret) r = mid;
            		else l = mid+1;
        		}
        		
        		if(sea.hasShips(new int[] {col, l}, new int[] {col, l})) res++;
        		
        		y = l+1;
        	}
        }
        
        
        return res;
    }
	
}

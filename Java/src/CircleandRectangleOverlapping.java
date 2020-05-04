
public class CircleandRectangleOverlapping {
	
	public boolean checkOverlap(int radius, int x, int y, int x1, int y1, int x2, int y2) {
        if(x >= x1 && x <= x2  && y >= y1 && y <= y2) return true;
        
        if(y >= y1 && y <= y2) {
        	if(Math.abs(x-x1) <= radius || Math.abs(x-x2) <= radius) return true;
        }
        
        if(x >= x1 && x <= x2) {
        	if(Math.abs(y-y1) <= radius || Math.abs(y-y2) <= radius) return true;
        }
        
        
        if(sq(x-x1) + sq(y-y1) <= sq(radius)) return true;
        if(sq(x-x2) + sq(y-y1) <= sq(radius)) return true;
        if(sq(x-x1) + sq(y-y2) <= sq(radius)) return true;
        if(sq(x-x2) + sq(y-y2) <= sq(radius)) return true;
        return false;
        
    }
	
	private int sq(int a) {
		return a*a;
	}
	
}

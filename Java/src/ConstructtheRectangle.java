
public class ConstructtheRectangle {
	
	public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        for(int i = sqrt; i > 0; i--) {
        	if(area % i == 0) return new int[] {area/i, i};
        }
        return null;
    }
	
}

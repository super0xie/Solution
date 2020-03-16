
public class CheckIfItIsaStraightLine {
	
	public boolean checkStraightLine(int[][] coordinates) {
		Double slope = Double.NaN;
        
        for(int i = 1; i < coordinates.length; i++) {
        	int dy = coordinates[i][1] - coordinates[i-1][1];
        	int dx = coordinates[i][0] - coordinates[i-1][0];
        	double s = 0;
        	if(dx == 0) s = Double.MAX_VALUE;
        	else s = ((double)dy)/dx;
        	
        	if(slope.isNaN()) slope = s;
        	else if(slope != s) return false;
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		CheckIfItIsaStraightLine test = new CheckIfItIsaStraightLine();
		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.println(test.checkStraightLine(coordinates));
		
		
	}
	
}

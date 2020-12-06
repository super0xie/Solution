import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
	
	public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.parallelSort(points, (a, b)->{return a[0]-b[0];});
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i < points.length; i++) {
        	max = Math.max(max, points[i][0]-points[i-1][0]);
        }
        return max;
    }
	
}

import java.util.Arrays;

public class RemoveCoveredIntervals {
	
	public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
        	if(a[0] != b[0]) return a[0]-b[0];
        	else return b[1]-a[1];
        	
        });
        
        int res = 1;
        int[] last = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
        	if(intervals[i][1] > last[1]) {
        		res++;
        		last = intervals[i];
        	}
        }
        return res;
    }
	
}

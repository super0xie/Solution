import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    
    public int findMinDifference(List<String> timePoints) {
        int[] m = new int[timePoints.size()];
        int idx = 0;
        for(String str : timePoints) {
            int h = Integer.parseInt(str.substring(0, 2));
            int mi = Integer.parseInt(str.substring(3));
            m[idx++] = 60 * h + mi;
        }
        
        Arrays.sort(m);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m.length-1; i++) {
            res = Math.min(res, m[i+1]-m[i]);
        }
        
        res = Math.min(res, m[0] + 24 * 60 - m[m.length-1]);
        return res;
    }
    
}

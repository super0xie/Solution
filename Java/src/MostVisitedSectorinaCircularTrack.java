import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorinaCircularTrack {
	
	public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n+1];
        count[rounds[0]]++;
        for(int i = 1; i < rounds.length; i++) {
        	int f = rounds[i-1];
        	int t = rounds[i];
        	if(t > f) {
        		for(int j = f+1; j <= t; j++) 
        			count[j]++;
        	}else {
        		for(int j = f+1; j <= n; j++) count[j]++;
        		for(int j = 1; j <= t; j++) count[j]++;
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) max = Math.max(count[i], max);
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
        	if(count[i] == max)
        		res.add(i);
        }
        
        return res;
        
    }
	
}

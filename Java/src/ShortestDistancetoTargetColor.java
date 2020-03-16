import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ShortestDistancetoTargetColor {
	
	public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer>[] trees = new TreeSet[4];
        
        for(int i = 0; i < colors.length; i++) {
        	if(trees[colors[i]] == null) trees[colors[i]] = new TreeSet<>();
        	trees[colors[i]].add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < queries.length; i++) {
        	if(trees[queries[i][1]] == null) {
        		res.add(-1);
        		continue;
        	}
        	
        	TreeSet<Integer> t = trees[queries[i][1]];
        	
        	
        	int idx = queries[i][0];
        	
        	if(t.contains(idx)) {
        		res.add(0);
        		continue;
        	}else {
        		int r = Integer.MAX_VALUE;
        		Integer floor = t.floor(idx);
        		if(floor != null) r = Math.min(r, idx-floor);
        		Integer ceiling = t.ceiling(idx);
        		if(ceiling != null) r = Math.min(r, ceiling-idx);
        		res.add(r);
        	}
        }
        return res;
    }
	
}

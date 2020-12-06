import java.util.ArrayList;
import java.util.List;

public class MinimumNumberofVerticestoReachAllNodes {
	
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] reachable = new boolean[n];
        for(List<Integer> e : edges) 
        	reachable[e.get(1)] = true;
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) if(!reachable[i]) res.add(i);
        return res;
    }
	
}

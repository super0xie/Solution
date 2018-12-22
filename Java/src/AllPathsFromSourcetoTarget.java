import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, graph, res, new ArrayList<Integer>());
        return res;
    }
	
	private void helper(int i, int[][] graph, List<List<Integer>> res, List<Integer> cur) {
		cur.add(i);
		if(i == graph.length-1) {
			List<Integer> aux = new ArrayList<>(cur);
			res.add(aux);
		}else {
			for(int j : graph[i]) {
				helper(j, graph, res, cur);
			}
		}
		cur.remove(cur.size()-1);
	}
	
}

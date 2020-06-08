import java.util.ArrayList;
import java.util.List;

public class MinimumTimetoCollectAllApplesinaTree {
	
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int[] e : edges) {
        	graph[e[0]].add(e[1]);
        	graph[e[1]].add(e[0]);
        }
        return dfs(0, -1, graph, hasApple);
    }
	
	private int dfs(int i, int from, ArrayList<Integer>[] g, List<Boolean> hasApple) {
		int res = 0;
		for(int adj : g[i]) {
			if(adj == from) continue;
			int ret = dfs(adj, i, g, hasApple);
			if(ret == 0 && !hasApple.get(adj)) continue;
			res += 2 + ret;
		}
		return res;
	}
	
}

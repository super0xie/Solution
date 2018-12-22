import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
	private boolean[] inStack;
	private boolean[] visited;
	private boolean[] inCycle;
	public List<Integer> eventualSafeNodes(int[][] graph) {
        inStack = new boolean[graph.length];
        visited = new boolean[graph.length];
        inCycle = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++) {
        	dfs(i, graph);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
        	if(!inCycle[i]) res.add(i);
        }
        return res;
    }
	
	private boolean dfs(int i, int[][] graph) {
		if(inStack[i]) {
			inCycle[i] = true;
		}
		if(inCycle[i]) return true;
		if(visited[i]) return false;
		visited[i] = true;
		inStack[i] = true;
		boolean res = false;
		for(int adj : graph[i]) {
			boolean aux = dfs(adj, graph);
			res = res || aux;
		}
		inStack[i] = false;
		if(res) inCycle[i] = true;
		return res;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0},{2,3,4},{3,4},{0,4},{}};
		FindEventualSafeStates test = new FindEventualSafeStates();
		test.eventualSafeNodes(graph);
	}
}

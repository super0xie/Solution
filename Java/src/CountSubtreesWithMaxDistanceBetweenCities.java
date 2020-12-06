import java.util.ArrayList;

public class CountSubtreesWithMaxDistanceBetweenCities {
	
	public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int max = 1;
        for(int i = 0; i < n; i++) max = max << 1;
        max--;
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        
        for(int[] e : edges) {
        	g[e[0]].add(e[1]);
        	g[e[1]].add(e[0]);
        }
        
        int[] res = new int[n-1];
        for(int bitmap = 3; bitmap <= max; bitmap++) {
        	int cur = bitmap;
        	boolean[] nodes = new boolean[n+1];
        	for(int i = 1; i <= n; i++) {
        		nodes[i] = cur % 2 == 1;
        		cur = cur >> 1;
        	}
        	
        	int dia = getDiameter(nodes, g);
        	if(dia > 0)
        		res[dia-1]++;
        }
        
        return res;
    }
	
	private int max;
	private int end;

	private int getDiameter(boolean[] nodes, ArrayList<Integer>[] g) {
		int first = -1;
		int total = 0;
		for(int i = 1; i < nodes.length; i++) {
			if(nodes[i]) {
				if(first < 0) first = i;
				total++;
			}
		}
		boolean[] visited = new boolean[nodes.length];
		max = Integer.MIN_VALUE;
		getFurthestNode(first, g, nodes, visited, 0);
		int visitedNodeCount = 0;
		for(boolean b : visited) if(b) visitedNodeCount++;
		if(total != visitedNodeCount) return -1;
		visited = new boolean[nodes.length];
		return getDiameterDFS(end, g, nodes, visited, 0);
	}
	
	private int getDiameterDFS(int i, ArrayList<Integer>[] g, boolean[] nodes, boolean[] visited, int step) {
		if(visited[i]) return 0;
		visited[i] = true;
		int res = step;
		for(int adj : g[i]) {
			if(nodes[adj]) res = Math.max(res, getDiameterDFS(adj, g, nodes, visited, step+1));
		}
		return res;
	}
	
	private void getFurthestNode(int i, ArrayList<Integer>[] g, boolean[] nodes, boolean[] visited, int step) {
		if(visited[i]) return;
		visited[i] = true;
		if(step > max) {
			max = step;
			end = i;
		}
		for(int adj : g[i]) {
			if(nodes[adj]) getFurthestNode(adj, g, nodes, visited, step+1);
		}
	}
	
	public static void main(String[] args) {
		CountSubtreesWithMaxDistanceBetweenCities test = new CountSubtreesWithMaxDistanceBetweenCities();
		int[][] edges = {{1,3},{1,4},{2,3}};
		test.countSubgraphsForEachDiameter(4, edges);
	}
	
	
	
}

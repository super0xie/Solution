import java.util.ArrayList;

public class NumberofNodesintheSubTreeWiththeSameLabel {
	
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for(int[] e : edges) {
        	g[e[0]].add(e[1]);
        	g[e[1]].add(e[0]);
        }
        
        int[] res = new int[n];
        
        dfs(0, labels, res, new boolean[n], g);
        return res;
    }
	
	private int[] dfs(int n, String labels, int[] res, boolean[] visited, ArrayList<Integer>[] g) {
		visited[n] = true;
		int[] ret = new int[26];
		for(int adj : g[n]) {
			if(visited[adj]) continue;
			int[] count = dfs(adj, labels, res, visited, g);
			for(int i = 0; i < 26; i++) 
				ret[i] += count[i];
		}
		
		ret[labels.charAt(n)-'a']++;
		res[n] = ret[labels.charAt(n)-'a'];
		return ret;
	}
	
	public static void main(String[] args) {
		NumberofNodesintheSubTreeWiththeSameLabel test = new NumberofNodesintheSubTreeWiththeSameLabel();
		int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
		test.countSubTrees(7, edges, "abaedcd");
				
	}
	
}

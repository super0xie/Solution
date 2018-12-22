import java.util.ArrayList;

public class PossibleBipartition {
	
	private boolean res = true;
	public boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int[] dislike : dislikes) {
        	if(graph[dislike[0]] == null) graph[dislike[0]] = new ArrayList<>();
        	graph[dislike[0]].add(dislike[1]);
        	if(graph[dislike[1]] == null) graph[dislike[1]] = new ArrayList<>();
        	graph[dislike[1]].add(dislike[0]);
        }
        
        int[] group = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
        	int g = 1;
        	if(group[i] != 0) g = group[i];
        	dfs(i, graph, group, g);
        }
        
        return res;
    }
	
	private void dfs(int i, ArrayList<Integer>[] graph, int[] group, int g) {
		if(group[i] != 0) {
			//visited
			if(group[i] != g) res = false;
			return;
		}
		
		group[i] = g;
		
		if(graph[i] != null) {
			for(int adj : graph[i]) {
				dfs(adj, graph, group, -g);
			}
		}
	}
	
	public static void main(String[] args) {
		PossibleBipartition test = new PossibleBipartition();
		int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
		System.out.println(test.possibleBipartition(5, dislikes));
	}
	
}

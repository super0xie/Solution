import java.util.ArrayList;

public class NumberofConnectedComponentsinanUndirectedGraph {
    
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < edges.length; i++) {
            if(graph[edges[i][0]] == null) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                graph[edges[i][0]] = list;
            }
            graph[edges[i][0]].add(edges[i][1]);
            
            
            if(graph[edges[i][1]] == null) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                graph[edges[i][1]] = list;
            }
            graph[edges[i][1]].add(edges[i][0]);

        }
        
        boolean[] visited = new boolean[n];
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, graph, visited);
            }
        }
        
        return res;
    }
    
    private void dfs(int n, ArrayList<Integer>[] graph, boolean[] visited) {
        if(visited[n]) return;
        visited[n] = true;
        
        if(graph[n] != null) {
            for(int i : graph[n]) {
                dfs(i, graph, visited);
            }
        }
        
    }
    
    public static void main(String[] args) {
        NumberofConnectedComponentsinanUndirectedGraph test = new NumberofConnectedComponentsinanUndirectedGraph();
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        test.countComponents(5, edges);
    }
    
}

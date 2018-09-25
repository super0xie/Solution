
public class IsGraphBipartite {
    

    public boolean isBipartite(int[][] graph) {
        int [] status = new int [graph.length];
        boolean [] visited = new boolean [graph.length];
        
        for(int i = 0; i < graph.length; i++) {
            boolean res = dfs(i, status, graph, visited);
            if(!res) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int i, int[] status, int[][] graph, boolean[] visited) {
        if(visited[i]) return true;
        visited[i] = true;
        
        if(status[i] == 0) status[i] = 1;
        
        for(int j : graph[i]) {
            if(status[j] == status[i]) return false;
            status[j] = status[i] == 1 ? 2 : 1;
            boolean res = dfs(j, status, graph, visited);
            if(!res) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsGraphBipartite test = new IsGraphBipartite();
        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        System.out.println(test.isBipartite(graph));
    }

}

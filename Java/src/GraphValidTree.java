import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        int[] uf = new int[n];
        for(int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++) {
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            
            boolean res = union(uf, p1, p2);
            if(!res) return false;
        }
        
        int root = getRoot(uf, 0);
        
        for(int i = 1; i < n; i++) {
            if(getRoot(uf, i) != root) return false;
        }
        
        return true;
        
    }
    
    private int getRoot(int[] uf, int i) {
        if(uf[i] == i) return i;
        else {
            int res = getRoot(uf, uf[i]);
            uf[i] = res;
            return res;
        }
    }
    
    private boolean union(int[] uf, int i, int j) {
        int ri = getRoot(uf, i);
        int rj = getRoot(uf, j);
        if(ri != rj) {
            uf[ri] = rj;
            return true;
        }else {
            return false;
        }
    }
    
    private boolean valid = true;
    public boolean validTreeDFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++) {
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            
            if(graph.containsKey(p1)) {
                graph.get(p1).add(p2);
            }else {
                List<Integer> nei = new ArrayList<Integer>();
                nei.add(p2);
                graph.put(p1, nei);
            }
            
            if(graph.containsKey(p2)) {
                graph.get(p2).add(p1);
            }else {
                List<Integer> nei = new ArrayList<Integer>();
                nei.add(p1);
                graph.put(p2, nei);
            }
        }
        
        dfs(-1, 0, graph, visited);
        if(!valid) return false;
        
        for(boolean visit : visited) {
            if(!visit) return false;
        }
        
        return true;
    }
    
    private void dfs(int from, int i, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        
        if(graph.containsKey(i)) {
            for(int j : graph.get(i)) {
                if(visited[j]) {
                    if(j != from) valid = false;
                }
                else dfs(i, j, graph, visited);
            }
        }
        
    }
    
}

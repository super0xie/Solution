import java.util.HashSet;

public class AllPathsfromSourceLeadtoDestination {

    private boolean res;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++) graph[i] = new HashSet<>();
        for(int[] e : edges) graph[e[0]].add(e[1]);
        res = true;
        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];

        dfs(source, graph, visited, onStack, destination);

        return res;
    }

    private void dfs(int n, HashSet<Integer>[] graph, boolean[] visited, boolean[] onStack, int dst){
        if(!res) return;
        visited[n] = true;
        onStack[n] = true;

        if(graph[n].size() == 0 && dst != n) {
            res = false;
            return;
        }

        for(int adj : graph[n]){
            if(onStack[adj]) {
                res = false;
                return;
            }else{
                if(!visited[adj]) dfs(adj, graph, visited, onStack, dst);
            }
        }

        onStack[n] = false;
    }

    public static void main(String[] args) {
        AllPathsfromSourceLeadtoDestination test = new AllPathsfromSourceLeadtoDestination();
        int[][] edges = {{0,1},{1,1},{1,2}};
        System.out.println(test.leadsToDestination(4, edges, 0, 2));
    }


}
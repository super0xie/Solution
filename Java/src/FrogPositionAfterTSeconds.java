import java.util.ArrayList;
import java.util.LinkedList;

public class FrogPositionAfterTSeconds {
    
    class Node{
        int n;
        double p;
        
        Node(int n, double p){
            this.n = n;
            this.p = p;
        }
    }
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int[] e : edges) {
            if(graph[e[0]] == null) graph[e[0]] = new ArrayList<>();
            graph[e[0]].add(e[1]);
            if(graph[e[1]] == null) graph[e[1]] = new ArrayList<>();
            graph[e[1]].add(e[0]);
        }
        
        if(target == 1 && graph[1] == null) return 1;
        
        LinkedList<Node> q = new LinkedList<>();
        q.add(new Node(1, 1));
        boolean[] visited = new boolean[n+1];
        int step = 1;
        visited[1] = true;
        while(!q.isEmpty()) {
            LinkedList<Node> aux = new LinkedList<>();
            
            while(!q.isEmpty()) {
                Node p = q.poll();
                
                if(graph[p.n] != null) {
                    int count = 0;
                    for(int adj : graph[p.n]) {
                        if(!visited[adj]) count++;
                    }
                    
                    if(p.n == target && count == 0 && step-1 <= t) return p.p;
                    
                    for(int adj : graph[p.n]) {
                        if(visited[adj]) continue;
                        
                        if(adj == target && step == t) {
                            return p.p / count;
                        }else {
                            visited[adj] = true;
                            aux.add(new Node(adj, p.p / count));
                        }
                    }
                    
                }
                
            }
            
            q = aux;
            step++;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        FrogPositionAfterTSeconds test = new FrogPositionAfterTSeconds();
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        System.out.println(test.frogPosition(7, edges, 20, 6));
    }
}

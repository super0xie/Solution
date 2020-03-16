import java.util.ArrayList;
import java.util.LinkedList;

public class TreeDiameter {
	
	public int treeDiameter(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[edges.length+1];
        for(int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
        	graph[edge[0]].add(edge[1]);
        	graph[edge[1]].add(edge[0]);
        }
        
        int node = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[edges.length+1];
        visited[0] = true;
        
        while(!queue.isEmpty()) {
        	int n = queue.poll();
        	
        	for(int adj : graph[n]) {
        		if(!visited[adj]) {
        			visited[adj] = true;
        			node = adj;
        			queue.add(adj);
        		}
        	}
        }
        
        visited = new boolean[edges.length+1];
        visited[node] = true;
        queue.add(node);
        int len = 0;
        while(!queue.isEmpty()) {
        	
        	LinkedList<Integer> aux = new LinkedList<>();
        	
        	while(!queue.isEmpty()) {
        		int n = queue.poll();
            	for(int adj : graph[n]) {
            		if(!visited[adj]) {
            			visited[adj] = true;
            			aux.add(adj);
            		}
            	}
        	}
        	len++;
        	queue = aux;
        }
        
        return len-1;
    }
	
	public static void main(String[] args) {
		TreeDiameter test = new TreeDiameter();
		int[][] edges = {{0,1},{0,2}};
		System.out.print(test.treeDiameter(edges));
	}
	

}

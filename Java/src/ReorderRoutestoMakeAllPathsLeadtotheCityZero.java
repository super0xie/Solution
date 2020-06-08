import java.util.ArrayList;
import java.util.LinkedList;

public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {
	
	public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[][] g = new ArrayList[n][2];
        for(int[] c : connections) {
        	int f = c[0];
        	int t = c[1];
        	if(g[f][0] == null) g[f][0] = new ArrayList<>();
        	g[f][0].add(t);
        	if(g[t][1] == null) g[t][1] = new ArrayList<>();
        	g[t][1].add(f);
        }
        
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int res = 0;
        
        while(!q.isEmpty()) {
        	int p = q.poll();
        	
        	if(g[p][0] != null) {
        		for(int t : g[p][0]) {
        			if(!visited[t]) {
        				q.add(t);
        				res++;
        				visited[t] = true;
        			}
        		}
        		
        	}
        	if(g[p][1] != null) {
        		for(int t : g[p][1]) {
        			if(!visited[t]) {
        				q.add(t);
        				visited[t] = true;
        			}
        		}
        	}
        	
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		ReorderRoutestoMakeAllPathsLeadtotheCityZero test = new ReorderRoutestoMakeAllPathsLeadtotheCityZero();
		int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		System.out.println(test.minReorder(6, connections));
	}
	
}

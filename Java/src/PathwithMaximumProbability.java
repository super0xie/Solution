import java.util.ArrayDeque;
import java.util.ArrayList;

public class PathwithMaximumProbability {
	
	class Pair{
		int i;
		double p;
		
		Pair(int i, double p){
			this.i = i;
			this.p = p;
		}
	}
	
	public double maxProbabilitydfs(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        prob[start] = 1;
        ArrayList<Pair>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
        	int[] e = edges[i];
        	g[e[0]].add(new Pair(e[1], succProb[i]));
        	g[e[1]].add(new Pair(e[0], succProb[i]));
        }
        
        dfs(prob, start, g);
        
        return prob[end];
    }
	
	private void dfs(double[] prob, int i, ArrayList<Pair>[] g) {
		for(Pair p : g[i]) {
			double np = prob[i] * p.p;
			if(np > prob[p.i]) {
				prob[p.i] = np;
				dfs(prob, p.i, g);
			}
		}
	}
	
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] prob = new double[n];
        prob[start] = 1;
        ArrayList<Pair>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
        	int[] e = edges[i];
        	g[e[0]].add(new Pair(e[1], succProb[i]));
        	g[e[1]].add(new Pair(e[0], succProb[i]));
        }
        
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.add(start);
        while(!l.isEmpty()) {
        	int i = l.poll();
        	
        	for(Pair p : g[i]) {
        		double np = prob[i] * p.p;
        		if(np > prob[p.i]) {
    				prob[p.i] = np;
    				l.add(p.i);
    			}
        	}
        	
        }
        
        return prob[end];
    }
	
	
	
}

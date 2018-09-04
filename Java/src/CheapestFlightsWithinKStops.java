import java.util.ArrayList;
import java.util.HashMap;

public class CheapestFlightsWithinKStops {
	private class Edge{
		int dst;
		int cost;
		
		Edge(int dst, int cost){
			this.dst = dst;
			this.cost = cost;
		}
	}
	
	HashMap<Integer, ArrayList<Edge>> graph;
	boolean [] onStack;
	int ans = Integer.MAX_VALUE;
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		onStack = new boolean [n];
		graph = new HashMap<Integer, ArrayList<Edge>>();
		for(int i = 0; i < flights.length; i++) {
			if(graph.containsKey(flights[i][0])) {
				graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
			}else {
				ArrayList<Edge> list = new ArrayList<Edge>();
				list.add(new Edge(flights[i][1], flights[i][2]));
				graph.put(flights[i][0], list);
			}
		}
		
		dfs(src, dst, 0, K+1);
		if(ans == Integer.MAX_VALUE) return -1;
		else return ans;
    }
	
	private void dfs(int src, int dst, int cost, int step) {
		if(onStack[src]) return;
		if(src == dst) {
			ans = cost;
			return;
		}
		if(step == 0) return;
		if(!graph.containsKey(src)) return;
		onStack[src] = true;
		ArrayList<Edge> list = graph.get(src);
		for(Edge e: list) {
			int curCost = cost+e.cost;
			if(curCost > ans) continue;
			dfs(e.dst, dst, curCost, step-1);
		}
		onStack[src] = false;
		
	}
	
	public static void main(String[] args) {
		CheapestFlightsWithinKStops test = new CheapestFlightsWithinKStops();
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		test.findCheapestPrice(3, flights, 0, 2, 0);
	}
}

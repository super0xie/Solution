import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
	public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int K) {
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
	
	private class Node{
		int cur;
		int cost;
		Node(int cur, int cost){
			this.cur = cur;
			this.cost = cost;
		}
	}
	
	public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K) {
		HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<Integer, HashMap<Integer, Integer>>();
		for(int i = 0; i < flights.length; i++) {
			HashMap<Integer, Integer> dsts = graph.getOrDefault(flights[i][0], new HashMap<Integer, Integer>());
			dsts.put(flights[i][1], flights[i][2]);
			graph.put(flights[i][0], dsts);
		}
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(src, 0));
		int res = Integer.MAX_VALUE;
		
		int[] disTo = new int[n];
		Arrays.fill(disTo, Integer.MAX_VALUE);
		disTo[src] = 0;
		
		while(!queue.isEmpty()) {
			LinkedList<Node> aux = new LinkedList<Node>();
			
			while(!queue.isEmpty()) {
				Node polled = queue.poll();
				HashMap<Integer, Integer> dsts = graph.get(polled.cur);
				if(dsts != null) {
					for(int key : dsts.keySet()) {
						int cost = polled.cost + dsts.get(key);
						if(cost < disTo[key]) {
							disTo[key] = cost;
							if(key == dst) res = Math.min(res, cost);
							else {
								aux.add(new Node(key, cost));
							}
						}
						
					}
				}
			}
			
			if(K == 0) break;
			K--;
			queue = aux;
		}
		if(res == Integer.MAX_VALUE) return -1;
		else return res;
    }
	
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<Integer, HashMap<Integer, Integer>>();
		for(int i = 0; i < flights.length; i++) {
			HashMap<Integer, Integer> dsts = graph.getOrDefault(flights[i][0], new HashMap<Integer, Integer>());
			dsts.put(flights[i][1], flights[i][2]);
			graph.put(flights[i][0], dsts);
		}
		
		int[][] dp = new int[K+1][n];
		int inf = Integer.MAX_VALUE / 2;
		for(int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], inf);
		}
		dp[0][src] = 0;
		
		if(graph.containsKey(src)) {
			for(int key : graph.get(src).keySet()) {
				dp[0][key] = graph.get(src).get(key);
			}
			for(int i = 0; i < K; i++) {
				
				for(int j = 0; j < n; j++) {
					if(dp[i][j] != inf) dp[i+1][j] = dp[i][j];
				}
				
				for(int j = 0; j < n; j++) {
					if(dp[i][j] != inf) {
						if(graph.containsKey(j)) {
							for(int k : graph.get(j).keySet()) {
								dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j]+graph.get(j).get(k));
							}
						}
					}
				}
			}
			
			if(dp[K][dst] == inf) return -1;
			else return dp[K][dst];
		}else {
			return -1;
		}
    }
	
	
	
	public static void main(String[] args) {
		CheapestFlightsWithinKStops test = new CheapestFlightsWithinKStops();
		int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		System.out.println(test.findCheapestPrice(4, flights, 0, 3, 1));
	}
}

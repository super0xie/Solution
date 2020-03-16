import java.util.ArrayList;

public class SumofDistancesinTree{
	
//	public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        int[] res = new int[N];
//        ArrayList<Integer>[] graph = new ArrayList[N];
//        for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
//        
//        for(int[] e : edges) {
//        	graph[e[0]].add(e[1]);
//        	graph[e[1]].add(e[0]);
//        }
//        
//        for(int i = 0; i < N; i++) {
//        	res[i] = dfs(i, 0, graph, new boolean[N]);
//        }
//        
//        return res;
//    }
//	
//	
//	private int dfs(int i, int depth, ArrayList<Integer>[] graph, boolean[] visited) {
//		visited[i] = true;
//		int sum = depth;
//		
//		for(int adj : graph[i]) {
//			if(!visited[adj]) {
//				sum += dfs(adj, depth+1, graph, visited);
//			}
//		}
//		
//		return sum;
//	}
	
	public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] res = new int[N];
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges) {
        	graph[e[0]].add(e[1]);
        	graph[e[1]].add(e[0]);
        }
        int[] count = new int[N];
        dfs(0, graph, -1, count);
        res[0] = dfs2(0, 0, graph, -1);
        dfs3(0, -1, count, graph, res, N);
        
        return res;
    }
	
	private int dfs(int i, ArrayList<Integer>[] graph, int from, int[] count) {
		int num = 1;
		for(int adj : graph[i]) {
			if(adj == from) continue;			
			num += dfs(adj, graph, i, count);
		}
		count[i] = num;
		return num;
	}
	
	private int dfs2(int i, int depth, ArrayList<Integer>[] graph, int from) {
		int sum = depth;
		for(int adj : graph[i]) {
			if(adj == from) continue;	
			sum += dfs2(adj, depth+1, graph, i);
		}
		return sum;
	}
	
	private void dfs3(int i, int from, int[] count, ArrayList<Integer>[] graph, int[] res, int N) {
		for(int adj : graph[i]) {
			if(adj == from) continue;
			res[adj] = res[i] - count[adj] + N - count[adj];
			dfs3(adj, i, count, graph, res, N);
		}
		
	}
	
	public static void main(String[] args) {
		SumofDistancesinTree test = new SumofDistancesinTree();
		int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
		int[] res = test.sumOfDistancesInTree(6, edges);
		for(int i : res) System.out.println(i + ",");
	}
	
}
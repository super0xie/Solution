import java.util.ArrayList;
import java.util.Arrays;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance {
	
	public int findTheCityOld(int n, int[][] edges, int distanceThreshold) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] e : edges) {
        	graph[e[0]].add(new int[] {e[1], e[2]});
        	graph[e[1]].add(new int[] {e[0], e[2]});
        }
        
        int minCount = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++) {
        	int[] dis = new int[n];
        	Arrays.fill(dis, Integer.MAX_VALUE);
        	dfs(i, dis, graph, 0, distanceThreshold);
        	int count = 0;
        	
        	for(int j = 0; j < n; j++) {
        		if(i == j) continue;
        		if(dis[j] <= distanceThreshold) count++;
        	}
        	
        	if(count <= minCount) {
        		minCount = count;
        		res = i;
        	}
        }
        return res;
    }
	
	private void dfs(int i, int[] dis, ArrayList<int[]>[] g, int l, int thres) {
		if(dis[i] <= l) return;
		dis[i] = l;
		if(l >= thres) return;
		
		for(int[] adj : g[i]) {
			dfs(adj[0], dis, g, l+adj[1], thres);
		}
	}
	
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int max = Integer.MAX_VALUE / 2;
        for(int i = 0; i < n; i++) {
        	Arrays.fill(dis[i], max);
        	dis[i][i] = 0;
        }
        
        for(int[] e : edges) {
        	dis[e[0]][e[1]] = e[2];
        	dis[e[1]][e[0]] = e[2];
        }
        
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			dis[i][j] = Math.min(dis[i][k] + dis[k][j], dis[i][j]);
        		}
        	}
        }
        
        int minCount = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < n; i++) {
        	int count = 0;
        	for(int j = 0; j < n; j++) {
        		if(i == j) continue;
        		if(dis[i][j] <= distanceThreshold) count++;
        	}
        	
        	if(count <= minCount) {
        		minCount = count;
        		res = i;
        	}
        }
        return res;
    }
	
	
	
	public static void main(String[] args) {
		int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
		FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance test = new FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance();
		System.out.println(test.findTheCity(5, edges, 2));
	}
	
}

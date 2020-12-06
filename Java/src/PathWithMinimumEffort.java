import java.util.ArrayDeque;
import java.util.Arrays;

public class PathWithMinimumEffort {
	
	private int m;
	private int n;
	private int[][] adj = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public int minimumEffortPathDFS(int[][] heights) {
		m = heights.length;
		n = heights[0].length;
		int[][] effort = new int[m][n];
		for(int i = 0; i < m; i++) Arrays.fill(effort[i], Integer.MAX_VALUE);
		effort[0][0] = 0;
		dfs(heights, effort, 0, 0);
		return effort[m-1][n-1];
    }
	
	private void dfs(int[][] heights, int[][] effort, int i, int j) {
		for(int k = 0; k < adj.length; k++) {
			int r = i + adj[k][0];
			int c = j + adj[k][1];
			
			if(r >= 0 && r < m && c >= 0 && c < n) {
				int ne = Math.max(Math.abs(heights[r][c] - heights[i][j]), effort[i][j]);
				if(ne < effort[r][c]) {
					effort[r][c] = ne;
					dfs(heights, effort, r, c);
				}
			}
		}
	}
	
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int[][] adj = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int[][] effort = new int[m][n];
		for(int i = 0; i < m; i++) Arrays.fill(effort[i], Integer.MAX_VALUE);
		ArrayDeque<int[]> q = new ArrayDeque<>();
		effort[0][0] = 0;
		q.add(new int[] {0, 0});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int i = p[0];
			int j = p[1];
			for(int k = 0; k < adj.length; k++) {
				int r = i + adj[k][0];
				int c = j + adj[k][1];
				
				if(r >= 0 && r < m && c >= 0 && c < n) {
					int ne = Math.max(Math.abs(heights[r][c] - heights[i][j]), effort[i][j]);
					if(ne < effort[r][c]) {
						effort[r][c] = ne;
						q.add(new int[] {r, c});
					}
				}
			}
		}
		
		return effort[m-1][n-1];
    }
	
	
	
	public static void main(String[] args) {
		PathWithMinimumEffort test = new PathWithMinimumEffort();
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		System.out.println(test.minimumEffortPath(heights));
	}
}

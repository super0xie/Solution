import java.util.LinkedList;

public class NumberofClosedIslands {
	
	private int[][] adj = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	private int m;
	private int n;
	public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        for(int j = 0; j < n; j++) {
        	if(grid[0][j] == 0)
        		bfs(grid, 0, j);
        	if(grid[m-1][j] == 0)
        		bfs(grid, m-1, j);
        }
        
        for(int i = 0; i < m; i++) {
        	if(grid[i][0] == 0)
        		bfs(grid, i, 0);
        	if(grid[i][n-1] == 0)
        		bfs(grid, i, n-1);
        }
        
        int res = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(grid[i][j] == 0) {
        			res++;
        			bfs(grid, i, j);
        		}
        	}
        }
        
        return res;
    }
	
	private void bfs(int[][] grid, int r, int c) {
		
		LinkedList<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		grid[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int k = 0; k < adj.length; k++) {
				int i = poll[0] + adj[k][0];
				int j = poll[1] + adj[k][1];
				
				if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 0) {
					grid[i][j] = 1;
					q.add(new int[] {i, j});
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		NumberofClosedIslands test = new NumberofClosedIslands();
		int[][] grid = {
				{0,1,1,1,1,1,1,1},
				{1,0,1,0,0,0,0,1},
				{1,0,0,0,0,1,0,1},
				{0,1,0,0,0,1,0,1},
				{1,0,0,1,0,1,0,1},
				{1,1,1,1,0,0,1,1},
				{1,0,0,0,0,0,1,1},
				{0,1,1,1,1,1,1,1}
				};
		System.out.println(test.closedIsland(grid));
	}
	
}

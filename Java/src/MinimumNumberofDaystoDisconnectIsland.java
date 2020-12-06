
public class MinimumNumberofDaystoDisconnectIsland {
	
	private int[][] adj = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public int minDays(int[][] grid) {
        if(disconnected(grid)) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(grid[i][j] == 0) continue;
        		grid[i][j] = 0;
        		if(disconnected(grid)) return 1;
        		grid[i][j] = 1;
        	}
        }
        
        return 2;
    }
	
	private boolean disconnected(int[][] grid) {
		int m = grid.length;
        int n = grid[0].length;
        
        int[][] cp = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		cp[i][j] = grid[i][j];
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(cp[i][j] == 1) {
        			dfs(cp, i, j);
        			i = m;
        			break;
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(cp[i][j] == 1) {
        			return true;
        		}
        	}
        }
        
        return false;
	}
	
	private void dfs(int[][] g, int i, int j) {
		g[i][j] = 0;
		int m = g.length;
		int n = g[0].length;
		for(int k = 0; k < adj.length; k++) {
			int r = i + adj[k][0];
			int c = j + adj[k][1];
			if(r >= 0 && r < m && c >= 0 && c < n) {
				if(g[r][c] == 1) dfs(g, r, c);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,0}};
		MinimumNumberofDaystoDisconnectIsland test = new MinimumNumberofDaystoDisconnectIsland();
		System.out.print(test.minDays(grid));
	}
	
	
	
}

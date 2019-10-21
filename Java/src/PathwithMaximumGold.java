
public class PathwithMaximumGold {
	
	private int m;
	private int n;
	private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public int getMaximumGold(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
        boolean[][] onStack = new boolean[m][n];
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(grid[i][j] != 0) res = Math.max(res, helper(grid, i, j, onStack));
        	}
        }
        
        return res;
    }
	
	private int helper(int[][] grid, int i, int j, boolean[][] onStack) {
		int res = grid[i][j];
		onStack[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int r = i + adj[k][0];
			int c = j + adj[k][1];
			
			if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 0 && !onStack[r][c]) {
				res = Math.max(res, grid[i][j] + helper(grid, r, c, onStack));
			}
		}
		
		onStack[i][j] = false;
		return res;
	}
	
	public static void main(String[] args) {
		PathwithMaximumGold test = new PathwithMaximumGold();
		int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
		System.out.println(test.getMaximumGold(grid));
	}
	
	
	
	
	
}

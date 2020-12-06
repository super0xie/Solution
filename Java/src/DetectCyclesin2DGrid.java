import java.util.HashMap;

public class DetectCyclesin2DGrid {
	
	private boolean res = false;
	private int[][] adj = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	private int m;
	private int n;
	public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int[][] stack = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(!visited[i][j]) dfs(i, j, visited, grid, 1, stack);
        		if(res) return res;
        	}
        }
        
        
        return res;
    }
	
	private void dfs(int i, int j, boolean[][] visited, char[][] grid, int step, int[][] stack) {
		visited[i][j] = true;
		stack[i][j] = step;
		for(int k = 0; k < adj.length; k++) {
			int r = i + adj[k][0];
			int c = j + adj[k][1];
			
			if(r >= 0 && r < m && c >= 0 && c < n) {
				
				if(stack[r][c] > 0 && step - stack[r][c] >= 3) {
					res = true;
					break;
				}
				
				if(!visited[r][c] && grid[r][c] == grid[i][j]) dfs(r, c, visited, grid, step+1, stack);
			}
		}
		
		stack[i][j] = 0;
	}
	
	public static void main(String[] args) {
		DetectCyclesin2DGrid test = new DetectCyclesin2DGrid();
		char[][] grid = {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
		System.out.println(test.containsCycle(grid));
	}
	
	
	
}

import java.util.ArrayList;

public class ColoringABorder {
	
	int[][] adj = {{0, 1},{0, -1},{1, 0},{-1, 0}};
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<int[]> border = new ArrayList<>();
        dfs(grid, r0, c0, visited, border);
        
        for(int[] l : border) {
        	grid[l[0]][l[1]] = color;
        }
        return grid;
    }
	
	private void dfs(int[][] grid, int r, int c, boolean[][] visited, ArrayList<int[]> border) {
		visited[r][c] = true;
		boolean isBorder = false;
		for(int k = 0; k < adj.length; k++) {
			int i = r + adj[k][0];
			int j = c + adj[k][1];
			
			if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
				if(grid[i][j] == grid[r][c] && !visited[i][j]) {
					dfs(grid, i, j, visited, border);
				}else if(grid[i][j] != grid[r][c]){
					isBorder = true;
				}
			}else {
				isBorder = true;
			}
		}
		
		if(isBorder) border.add(new int [] {r, c});
	}
	
}

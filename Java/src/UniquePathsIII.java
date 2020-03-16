
public class UniquePathsIII {
	
	private int res;
	private boolean[][] visited;
	private int tar;
	public int uniquePathsIII(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int si = 0;
        int sj = 0;
        tar = 2;
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			si = i;
        			sj = j;
        		}else if(grid[i][j] == 0) {
        			tar++;
        		}
        	}
        }
        
        dfs(si, sj, grid, 0);
        
        return res;
    }
	
	private void dfs(int i, int j, int[][] grid, int step) {
		if(visited[i][j]) return;
		if(grid[i][j] == -1) return;
		visited[i][j] = true;
		step++;
		if(grid[i][j] == 2 && step == tar) res++;
		
		if(i > 0) dfs(i-1, j, grid, step);
		if(i < grid.length-1) dfs(i+1, j, grid, step);
		if(j > 0) dfs(i, j-1, grid, step);
		if(j < grid[0].length-1) dfs(i, j+1, grid, step);
		
		visited[i][j] = false;
	}
}

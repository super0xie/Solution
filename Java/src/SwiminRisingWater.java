
public class SwiminRisingWater {
	
	private int N;
	public int swimInWater(int[][] grid) {
		N = grid.length;
        int start = grid[0][0];
        int end = grid.length * grid.length - 1;
        
        while(start < end) {
        	int mid = start + (end - start) / 2;
        	if(!dfs(grid, mid)) start = mid + 1;
        	else end = mid;
        }
        
        return start;
    }
	
	private boolean dfs(int[][] grid, int t) {
		boolean [][] visited = new boolean[N][N];
		dfs(grid, visited, 0, 0, t);
		if(visited[N-1][N-1]) return true;
		return false;
	}
	
	private void dfs(int[][] grid, boolean[][] visited, int i, int j, int t) {
		if(visited[i][j]) return;
		visited[i][j] = true;
		
		if(i > 0 && grid[i-1][j] <= t) dfs(grid, visited, i-1, j, t);
		if(i < N-1 && grid[i+1][j] <= t) dfs(grid, visited, i+1, j, t);
		if(j > 0 && grid[i][j-1] <= t) dfs(grid, visited, i, j-1, t);
		if(j < N-1 && grid[i][j+1] <= t) dfs(grid, visited, i, j+1, t);
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
		SwiminRisingWater test = new SwiminRisingWater();
		System.out.println(test.swimInWater(grid));
	}
}

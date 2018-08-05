
public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int counter = 0;
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(dfs(i, j, grid, visited)) counter++;
        	}
        }
        
        return counter;
    }
	
	private boolean dfs(int i, int j, char[][] grid, boolean[][] visited) {
		if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length -1) return false;
		if(visited[i][j]) return false;
		if(grid[i][j] == '0') return false;
		
		
		visited[i][j] = true;
		
		dfs(i-1, j, grid, visited);
		dfs(i+1, j, grid, visited);
		dfs(i, j-1, grid, visited);
		dfs(i, j+1, grid, visited);
		
		return true;
		
	}
	
	public static void main(String[] args) {
		NumberOfIslands test = new NumberOfIslands();
		
		char[][] grid = {
				{'1', '1', '0', '0', '0'}, 
				{'1', '1', '0', '0', '0'}, 
				{'0', '0', '1', '0', '0'}, 
				{'0', '0', '0', '1', '1'}};
		
		int result = test.numIslands(grid);
		
		System.out.println(result);
	}

}

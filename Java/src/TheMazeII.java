import java.util.Arrays;

public class TheMazeII {
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][maze[0].length];
        
        for(int i = 0; i < visited.length; i++) {
        	Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        
        dfs(maze, start[0], start[1], 0, destination[0], destination[1], visited);
        if(visited[destination[0]][destination[1]] == Integer.MAX_VALUE) return -1;
        else return visited[destination[0]][destination[1]];
    }
	
	private void dfs(int[][] maze, int i, int j, int sum, int r, int c, int[][] visited) {
		if(sum >= visited[i][j]) return;
		visited[i][j] = sum;
		if(i == r && j == c) return;
		
		int row = i;
        int col = j;
        while(row > 0 && maze[row-1][col] != 1) row--;
        dfs(maze, row, col, sum+i-row, r, c, visited);
        
        row = i;
        col = j;
        while(row < maze.length-1 && maze[row+1][col] != 1) row++;
        dfs(maze, row, col, sum+row-i, r, c, visited);
        
        row = i;
        col = j;
        while(col > 0 && maze[row][col-1] != 1) col--;
        dfs(maze, row, col, sum+j-col, r, c, visited);
        
        row = i;
        col = j;
        while(col < maze[0].length-1 && maze[row][col+1] != 1) col++;
        dfs(maze, row, col, sum+col-j, r, c, visited);
	}
	
	public static void main(String[] args) {
		TheMazeII test = new TheMazeII();
		int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		System.out.println(test.shortestDistance(maze, new int[] {0, 4}, new int [] {4, 4}));
	}
	
}

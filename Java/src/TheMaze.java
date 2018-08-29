
public class TheMaze {
    private boolean [][] visited;
    private int[][] maze;
    private int[] destination;
   
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean [maze.length][maze[0].length];
        this.maze = maze;
        this.destination = destination;
        return dfs(start[0], start[1]);
    
    }
    
    private boolean dfs(int i, int j) {
        visited[i][j] = true;
        if(i==destination[0] && j == destination[1]) return true;
        
        int row = i;
        int col = j;
        while(row > 0 && maze[row-1][col] != 1) row--;
        if(!visited[row][col] && dfs(row, col)) return true;
        
        row = i;
        col = j;
        while(row < maze.length-1 && maze[row+1][col] != 1) row++;
        if(!visited[row][col] && dfs(row, col)) return true;
        
        row = i;
        col = j;
        while(col > 0 && maze[row][col-1] != 1) col--;
        if(!visited[row][col] && dfs(row, col)) return true;
        
        row = i;
        col = j;
        while(col < maze[0].length-1 && maze[row][col+1] != 1) col++;
        if(!visited[row][col] && dfs(row, col)) return true;
            
        return false;
    }
    
    
}

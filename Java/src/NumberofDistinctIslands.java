import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberofDistinctIslands {
    
    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        HashSet<String> islands = new HashSet<String>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    List<int[]> list = new ArrayList<>();
                    dfs(i, j, list, visited, grid);
                    
                    StringBuilder sb = new StringBuilder();
                    //encode
                    for(int id = 0; id < list.size(); id++) {
                        int[] coor = list.get(id);
                        int ri = coor[0]-i;
                        int rj = coor[1]-j;
                        
                        sb.append(ri + ",");
                        sb.append(rj + ",");
                    }
                    
                    islands.add(sb.toString());
                    
                }
            }
        }
        
        return islands.size();
    }
    
    private void dfs(int i, int j, List<int[]> list, boolean[][] visited, int[][] grid) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        list.add(new int [] {i ,j});
        
        for(int k = 0; k < 4; k++) {
            int r = i + adj[k][0];
            int c = j + adj[k][1];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                dfs(r, c, list, visited, grid);
            }
        }
    }
    
    public static void main(String[] args) {
        NumberofDistinctIslands test = new NumberofDistinctIslands();
        int[][] grid = {{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        test.numDistinctIslands(grid);
    }
    
}

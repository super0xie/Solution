import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid {
    
    public int minCostWrong(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m-1][n-1] = 0;
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        boolean cont = true;
        while(cont) {
            cont = false;
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int old = dp[i][j];
                    for(int k = 0; k < 3; k++) {
                        int r = i + adj[k][0];
                        int c = j + adj[k][1];
                        
                        if(r >= 0 && r < m && c >= 0 && c < n) {
                            if(dp[r][c] == Integer.MAX_VALUE) continue;
                            
                            if(grid[i][j]-1 == k) {
                                dp[i][j] = Math.min(dp[i][j], dp[r][c]);
                            }else {
                                dp[i][j] = Math.min(dp[i][j], dp[r][c]+1);
                            }
                        }
                        
                    }
                    if(dp[i][j] != old) cont = true;
                }
            }
            
        }
        
        return dp[0][0];
    }
    
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m-1][n-1] = 0;
        int[][] adj = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {m-1, n-1});
        int step = 0;
        while(!q.isEmpty()) {
            ArrayList<int[]> aux = new ArrayList<>();
            while(!q.isEmpty()) {
                int[] p = q.poll();
                aux.add(p);
                
                
                for(int k = 0; k < 4; k++) {
                    int r = p[0] + adj[k][0];
                    int c = p[1] + adj[k][1];
                    
                    if(r >= 0 && r < m && c >= 0 && c < n && dp[r][c] == Integer.MAX_VALUE) {
                        if(grid[r][c]-1 == k) {
                            q.add(new int [] {r, c});
                            dp[r][c] = step;
                        }
                    }
                }
            }
            
            step++;
            for(int[] node : aux) {
                for(int k = 0; k < 4; k++) {
                    int r = node[0] + adj[k][0];
                    int c = node[1] + adj[k][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && dp[r][c] == Integer.MAX_VALUE) {
                        dp[r][c] = step;
                        q.add(new int[] {r, c});
                    }
                }
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        MinimumCosttoMakeatLeastOneValidPathinaGrid test = new MinimumCosttoMakeatLeastOneValidPathinaGrid();
        int[][] grid = {{1,2},{4,3}};
        System.out.println(test.minCost(grid));
    }
    
}

import java.util.Arrays;

public class CherryPickup {
	
	public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int min = Integer.MIN_VALUE / 2;
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
        	Arrays.fill(dp[i], min);
        dp[0][0] = grid[0][0];
        
        for(int t = 1; t <= 2*n-2; t++) {
        	int[][] ndp = new int[n][n];
        	for(int i = 0; i < n; i++)
            	Arrays.fill(ndp[i], min);
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			if(t-i < 0 || t-i >= n || t-j < 0 || t-j >= n) continue;
        			if(grid[i][t-i] == -1 || grid[j][t-j] == -1) continue;
        			
        			int val = grid[i][t-i];
        			if(i != j) val += grid[j][t-j];
        			
        			if(dp[i][j] != min) ndp[i][j] = Math.max(ndp[i][j], dp[i][j] + val);
        			if(i > 0 && dp[i-1][j] != min) ndp[i][j] = Math.max(ndp[i][j], dp[i-1][j] + val);
        			if(j > 0 && dp[i][j-1] != min) ndp[i][j] = Math.max(ndp[i][j], dp[i][j-1] + val);
        			if(i > 0 && j > 0 &&  dp[i-1][j-1] != min) ndp[i][j] = Math.max(ndp[i][j], dp[i-1][j-1] + val);
        		}
        	}
        	
        	dp = ndp;
        }
        
        if(dp[n-1][n-1] == min) return 0;
        
        return dp[n-1][n-1];
    }
	
	public static void main(String[] args) {
		CherryPickup test = new CherryPickup();
		int[][] grid = {{1,1,-1},{1,-1,1},{-1,1,1}};
		System.out.println(test.cherryPickup(grid));
	}
	
}

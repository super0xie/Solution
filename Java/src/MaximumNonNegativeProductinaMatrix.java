
public class MaximumNonNegativeProductinaMatrix {
//	public int maxProductPath(int[][] grid) {
//		int m = grid.length;
//		int n = grid[0].length;
//        int[][][] dp = new int[m][n][2];
//        
//        dp[0][0][0] = grid[0][0];
//        dp[0][0][1] = grid[0][0];
//        
//        for(int i = 0; i < m; i++) {
//        	for(int j = 0; j < n; j++) {
//        		if(i == 0 && j == 0) continue;
//        		int k = grid[i][j];
//        		dp[i][j][0] = Integer.MIN_VALUE;
//        		dp[i][j][1] = Integer.MAX_VALUE;
//        		
//        		if(i > 0) {
//        			if(k > 0) {
//        				dp[i][j][0] = Math.max(dp[i][j][0], k * dp[i-1][j][0]);
//        				dp[i][j][1] = Math.min(dp[i][j][1], k * dp[i-1][j][1]);
//        			} else if(k < 0) {
//        				dp[i][j][0] = Math.max(dp[i][j][0], k * dp[i-1][j][1]);
//        				dp[i][j][1] = Math.min(dp[i][j][1], k * dp[i-1][j][0]);
//        			}
//        		}
//        		
//        		if(j > 0) {
//        			if(k > 0) {
//        				dp[i][j][0] = Math.max(dp[i][j][0], k * dp[i][j-1][0]);
//        				dp[i][j][1] = Math.min(dp[i][j][1], k * dp[i][j-1][1]);
//        			} else if(k < 0) {
//        				dp[i][j][0] = Math.max(dp[i][j][0], k * dp[i][j-1][1]);
//        				dp[i][j][1] = Math.min(dp[i][j][1], k * dp[i][j-1][0]);
//        			}
//        		}
//        	}
//        }
//        
//        return dp[m-1][n-1][0];
//    }
	
	public int maxProductPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        int mod = 1000000000+7;
        
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0 && j == 0) continue;
        		int k = grid[i][j];
        		dp[i][j][0] = Integer.MIN_VALUE;
        		dp[i][j][1] = Integer.MAX_VALUE;
        		
        		if(i > 0) {
    				dp[i][j][0] = Math.max(dp[i][j][0], Math.max(k * dp[i-1][j][0], k * dp[i-1][j][1]));
    				dp[i][j][1] = Math.min(dp[i][j][1], Math.min(k * dp[i-1][j][0], k * dp[i-1][j][1]));
        		}
        		
        		if(j > 0) {
    				dp[i][j][0] = Math.max(dp[i][j][0], Math.max(k * dp[i][j-1][0], k * dp[i][j-1][1]));
    				dp[i][j][1] = Math.min(dp[i][j][1], Math.min(k * dp[i][j-1][0], k * dp[i][j-1][1]));
        		}
        	}
        }
        if(dp[m-1][n-1][0] < 0) return -1;
        return (int)(dp[m-1][n-1][0] % mod);
    }
	
	public static void main(String[] args) {
		int[][] grid = {{ 1, 4,4,0},
	               {-2, 0,0,1},
	               { 1,-1,1,1}};
		MaximumNonNegativeProductinaMatrix test = new MaximumNonNegativeProductinaMatrix();
		System.out.println(test.maxProductPath(grid));
	}
}

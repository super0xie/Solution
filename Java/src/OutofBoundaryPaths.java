
public class OutofBoundaryPaths {
    
    public int findPaths(int m, int n, int N, int i, int j) {
        if(m == 0 || n == 0 || N == 0) return 0;
        int[][][] dp = new int[N][m][n];
        int mod = 1000000007;
        for(int r = 0; r < m; r++) {
            dp[0][r][0]++;
            dp[0][r][n-1]++;
        }
        
        for(int c = 0; c < n; c++) {
            dp[0][0][c]++;
            dp[0][m-1][c]++;
        }
        
        int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int k = 1; k < N; k++) {
            for(int r = 0; r < m; r++) {
                for(int c = 0; c < n; c++) {
                    for(int a = 0; a < 4; a++) {
                        int rr = r + adj[a][0];
                        int cc = c + adj[a][1];
                        if(rr >= 0 && rr < m && cc >= 0 && cc < n) {
                            dp[k][r][c] += dp[k-1][rr][cc];
                        }else {
                            dp[k][r][c] += 1;
                        }
                        dp[k][r][c] = dp[k][r][c]%mod;
                    }
                    
                }
            }
        }
        
        return dp[N-1][i][j];
    }
    
    public static void main(String[] args) {
        OutofBoundaryPaths test = new OutofBoundaryPaths();
        test.findPaths(2, 2, 2, 0, 0);
    }
    
}

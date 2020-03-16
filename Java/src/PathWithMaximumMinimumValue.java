public class PathWithMaximumMinimumValue{

    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;
    public int maximumMinimumPathOld(int[][] A) {
        m = A.length;
        n = A[0].length;

        int[][] min = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                min[i][j] = -1;

        dfs(0, 0, min, A, A[0][0]);
        
        return min[m-1][n-1];
    }

    public int maximumMinimumPath(int[][] A) {
        m = A.length;
        n = A[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;

        boolean needUpdate = true;
        dp[0][0] = A[0][0];

        while(needUpdate){
            needUpdate = false;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < 4; k++){
                        int r = i + adj[k][0];
                        int c = j + adj[k][1];
                        if(r >= 0 && r < m && c >= 0 && c < n){
                            if(dp[r][c] == -1) continue;
                            if(dp[i][j] != -1 && dp[r][c] <= dp[i][j]) continue;
                            int tmp = Math.min(A[i][j], dp[r][c]);
                            if(dp[i][j] == -1 || tmp > dp[i][j]) {
                            	needUpdate = true;
                            	dp[i][j] = tmp;
                            }
                        }
                    }
                }
            }

        }
        
        return dp[m-1][n-1];
    }

    private void dfs(int i, int j, int[][] min, int[][] A, int val){
        if(min[i][j] != -1 && val <= min[i][j]) return;
        min[i][j] = Math.min(A[i][j], val);

        for(int k = 0; k < 4; k++){
            int r = i + adj[k][0];
            int c = j + adj[k][1];

            if(r >= 0 && r < m && c >= 0 && c < n){
                dfs(r, c, min, A, min[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        PathWithMaximumMinimumValue test = new PathWithMaximumMinimumValue();
        int[][] A = {{5,4,5},{1,2,6},{7,4,6}};
        System.out.println(test.maximumMinimumPath(A));
    }

}
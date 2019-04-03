public class NumberofEnclaves{

    public int numEnclaves(int[][] A) {
        for(int j = 0; j < A[0].length; j++){
            if(A[0][j] == 1) dfs(A, 0, j);
            if(A[A.length-1][j] == 1) dfs(A, A.length-1, j);
        }

        for(int i = 0; i < A.length; i++){
            if(A[i][0] == 1) dfs(A, i, 0);
            if(A[i][A[0].length-1] == 1) dfs(A, i, A[0].length-1);
        }
        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1) res++;
            }
        }

        return res;
    }

    private int[][] adj = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void dfs(int[][] A, int i, int j){
        A[i][j] = 0;
        for(int k = 0; k < adj.length; k++){
            int r = i + adj[k][0];
            int c = j + adj[k][1];
            if(r >= 0 && r < A.length && c >= 0 && c < A[0].length && A[r][c] == 1) dfs(A, r, c);
        }
    }

}
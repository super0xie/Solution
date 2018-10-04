
public class KnightProbabilityinChessboard {
    
    public double knightProbability(int N, int K, int r, int c) {
        if(K == 0) return 1;
        double[][][] mem = new double[K][N][N];
        int[][] adj = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
        return dfs(r, c, K, N, mem, adj);
    }
    
    private double dfs(int i, int j, int K, int N, double[][][] mem, int[][] adj) {
        if(i < 0 || i >= N || j < 0 || j >= N) return 0;
        if(K == 0) return 1;
        
        if(mem[K-1][i][j] > 0) return mem[K-1][i][j];
        
        double sum = 0;
        for(int k = 0; k < 8; k++) {
            int tarI = i + adj[k][0];
            int tarJ = j + adj[k][1];
            sum += dfs(tarI, tarJ, K-1, N, mem, adj);
        }
        sum = sum * 0.125;
        mem[K-1][i][j] = sum;
        return sum;
    }
    
    public static void main(String[] args) {
//        KnightProbabilityinChessboard test = new KnightProbabilityinChessboard();
//        System.out.println(test.knightProbability(3, 2, 0, 0));
        
        
        
    }
    
}


public class LongestIncreasingPathinaMatrix {
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 1;
        int[][] mem = new int[matrix.length][matrix[0].length];
        
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, mem));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if(mem[i][j] > 0) return mem[i][j];
        
        int res = 1;
        if(i > 0 && matrix[i-1][j] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i-1, j, mem));
        }
        
        if(i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i+1, j, mem));
        }
        
        if(j > 0 && matrix[i][j-1] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i, j-1, mem));
        }
        
        if(j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i, j+1, mem));
        }
        
        mem[i][j] = res;
        return res;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
              };
        LongestIncreasingPathinaMatrix test = new LongestIncreasingPathinaMatrix();
        System.out.println(test.longestIncreasingPath(matrix));
        
    }

}

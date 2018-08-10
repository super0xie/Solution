
public class SpiralMatrixII {
    
    private int n;
    private int total;
    
    
    public int[][] generateMatrix(int n) {
        this.n = n;
        this.total = n * n;
        
        int[][] result = new int[n][n];
        
        helper(result, 1, 0, 0, 0);
        return result;
    }
    
    private void helper(int[][] matrix, int counter, int dir, int i, int j) {
        matrix[i][j] = counter;
        if(counter == total) return;
        
        if(dir == 0) {
            if(j < n - 1 && matrix[i][j+1] == 0) {
                helper(matrix, counter+1, dir, i, j+1);
            }else {
                helper(matrix, counter+1, 1, i+1, j);
            }
        }else if(dir == 1) {
            if(i < n-1 && matrix[i+1][j] == 0) {
                helper(matrix, counter+1, dir, i+1, j);
            }else {
                helper(matrix, counter+1, 2, i, j-1);
            }
        }else if(dir == 2) {
            if(j > 0 && matrix[i][j-1] == 0) {
                helper(matrix, counter+1, dir, i, j-1);
            }else {
                helper(matrix, counter+1, 3, i-1, j);
            }
        }else {
            if(i > 0 && matrix[i-1][j] == 0) {
                helper(matrix, counter+1, dir, i-1, j);
            }else {
                helper(matrix, counter+1, 0, i, j+1);
            }
        }
    }
    
    public static void main(String[] args) {
        SpiralMatrixII test = new SpiralMatrixII();
        int[][] result = test.generateMatrix(3);
        
        System.out.println("ok");
    }
}

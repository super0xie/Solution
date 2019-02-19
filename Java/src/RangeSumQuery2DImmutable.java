public class RangeSumQuery2DImmutable{

    private int[][] prefix;

    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        prefix = new int[m][n];

        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix[i][j];
                prefix[i][j] = sum;
            }
        }

        for(int j = 0; j < n; j++){
            int sum = 0;
            for(int i = 0; i < m; i++){
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = prefix[row2][col2];
        if(row1 > 0) res -= prefix[row1-1][col2];
        if(col1 > 0) res -= prefix[row2][col1-1];
        if(row1 > 0 && col1 > 0) res += prefix[row1-1][col1-1];
        return res;
    }
}
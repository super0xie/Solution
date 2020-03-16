
public class MatrixBlockSum {
	
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int m = mat.length;
        if(m == 0) return null;
        int n = mat[0].length;
                
        int[][] prefix = new int[m][n];
        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += mat[i][j];
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
        
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		res[i][j] = sumRegion(prefix, i-K, j-K, i+K, j+K, m, n);
        	}
        }
        
        return res;
    }
    
    public int sumRegion(int[][] prefix, int row1, int col1, int row2, int col2, int m, int n) {
    	if(row2 >= m) row2 = m-1;
    	if(col2 >= n) col2 = n-1;
    	if(row1 < 0) row1 = 0;
    	if(col1 < 0) col1 = 0;
    	
    	
        int res = prefix[row2][col2];
        if(row1 > 0) res -= prefix[row1-1][col2];
        if(col1 > 0) res -= prefix[row2][col1-1];
        if(row1 > 0 && col1 > 0) res += prefix[row1-1][col1-1];
        return res;
    }
	
}

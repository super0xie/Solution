
public class CountSquareSubmatriceswithAllOnes {
	
	public int countSquares(int[][] matrix) {
		int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefix = new int[m][n];
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
        
        
        int res = 0;

        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		int len = 1;
        		while(i + len - 1 < m && j + len - 1 < n) {
        			if(sum(prefix, i, j, i+len-1, j+len-1) == len * len) res++;
        			else break;
        			len++;
        		}
        	}
        }
                        
        return res;
    }
	
	private int sum(int[][] prefix, int x1, int y1, int x2, int y2){
        int res = prefix[x2][y2];
        if(x1 > 0) res -= prefix[x1-1][y2];
        if(y1 > 0) res -= prefix[x2][y1-1];
        if(x1 > 0 && y1 > 0) res += prefix[x1-1][y1-1];
        return res;
    }
	
	public static void main(String[] args) {
		CountSquareSubmatriceswithAllOnes test = new CountSquareSubmatriceswithAllOnes();
		int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		System.out.println(test.countSquares(matrix));
	}
	
}

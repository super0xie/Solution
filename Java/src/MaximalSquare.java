
public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) return 0;
		int res = 0;
		int[][] aux = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
        	int sum = 0;
        	for(int j = 0 ; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			sum++;
        			res = 1;
        		}
        		aux[i][j] = sum;
        	}
        }
        
        for(int j = 0; j < matrix[0].length; j++) {
        	int sum = 0;
        	for(int i = 0; i < matrix.length; i++) {
        		sum += aux[i][j];
        		aux[i][j] = sum;
        	}
        }
      
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			int r = i+1;
        			int c = j+1;
        			while(r < matrix.length && c < matrix[0].length && matrix[r][c] == '1') {
        				int area = aux[r][c];
        				if(i > 0 && j > 0) area += aux[i-1][j-1];
        				if(j > 0) area -= aux[r][j-1];
        				if(i > 0) area -= aux[i-1][c];
        				
        				if(area == (r-i+1) * (r-i+1)) {
        					res = Math.max(res, area);
        					r++;
        					c++;
        				}else {
        					break;
        				}
        			}
        		}
        		
        	}
        }
        
        return res;
        
    }
	
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		MaximalSquare test = new MaximalSquare();
		test.maximalSquare(matrix);
	}
	
}

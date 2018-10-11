
public class ReshapetheMatrix {
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        
        if(r*c != m*n) return nums;
        
        int[][] res = new int[r][c];
        int ii = 0;
        int jj = 0;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		res[ii][jj] = nums[i][j];
        		if(jj == c-1) {
        			jj = 0;
        			ii++;
        		}else {
        			jj++;
        		}
        	}
        }
        
        return res;
        
    }
	
}

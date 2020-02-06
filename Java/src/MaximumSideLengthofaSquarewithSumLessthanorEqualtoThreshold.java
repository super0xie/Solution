
public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
	
	private int m;
	private int n;
	
	public int maxSideLength(int[][] mat, int threshold) {
		m = mat.length;
		n = mat[0].length;
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
        int l = 0;
        int r = Math.min(m, n);
        
        while(l < r) {
        	int mid = l + (r-l)/2 + 1;
        	if(valid(prefix, mid, threshold)) {
        		l = mid;
        	}else {
        		r = mid-1;
        	}
        }
        
        return l;
    }
	
	private int sumRegion(int[][] prefix, int r1, int c1, int r2, int c2) {
        int res = prefix[r2][c2];
        if(r1 > 0) res -= prefix[r1-1][c2];
        if(c1 > 0) res -= prefix[r2][c1-1];
        if(r1 > 0 && c1 > 0) res += prefix[r1-1][c1-1];
        return res;
    }
	
	
	private boolean valid(int[][] prefix, int len, int thres) {
		for(int i = 0; i + len - 1 < m; i++) {
			for(int j = 0; j + len -1 < n; j++) {
				int sum = sumRegion(prefix, i, j, i+len-1, j+len-1);
				if(sum <= thres) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold test = new MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold();
		int[][] mat = {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
		System.out.println(test.maxSideLength(mat, 6));
	}
	
}

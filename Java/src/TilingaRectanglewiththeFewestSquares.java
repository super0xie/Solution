
public class TilingaRectanglewiththeFewestSquares {
	
	private int max;
	private int n;
	private int m;
	private int total;
	
	public int tilingRectangle(int n, int m) {
        boolean[][] mat = new boolean[n][m];

        max = Math.max(n, m);
        this.n = n;
        this.m = m;
        total = m * n;
        
        return helper(0, 0, 1, mat, 0);
    }
	
	
	private int helper(int i, int j, int count, boolean[][] mat, int sum) {
		if(count == max) return count;
		
		int len = 0;
		int res = max;
		
		while(i + len < n && j + len < m) {
			int r = 0;
			int c = 0;
			
			for(r = i; r <= i+len; r++) {
				for(c = j; c <= j+len; c++) {
					if(mat[r][c]) break;
				}
				if(c <= j+len) break;
			}
			
			if(r <= i+len || c <= j+len) break;
			
			int newSum = sum + (len+1) * (len+1);
			if(newSum == total) {
				return count;
			}
			
			for(r = i; r <= i+len; r++) {
				for(c = j; c <= j+len; c++) {
					mat[r][c] = true;
				}
			}
			
			
			for(r = 0; r < n; r++) {
				for(c = 0; c < m; c++) {
					if(!mat[r][c]) break;
				}
				if(c < m) break;
			}
			
			res = Math.min(res, helper(r, c, count+1, mat, newSum));
			
			for(r = i; r <= i+len; r++) {
				for(c = j; c <= j+len; c++) {
					mat[r][c] = false;
				}
			}
			
			len++;
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		TilingaRectanglewiththeFewestSquares test = new TilingaRectanglewiththeFewestSquares();
		System.out.println(test.tilingRectangle(11, 13));
	}
	
}

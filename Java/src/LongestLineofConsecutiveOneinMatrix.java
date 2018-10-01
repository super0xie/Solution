
public class LongestLineofConsecutiveOneinMatrix {
	
	public int longestLine(int[][] M) {
		int res = 0;
		if(M.length == 0 || M[0].length == 0) return 0;
		int m = M.length;
		int n = M[0].length;
		for(int i = 0; i < m; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(M[i][j] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			int count = 0;
			for(int i = 0; i < m; i++) {
				if(M[i][j] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			int r = i;
			int c = 0;
			int count = 0;
			while(r < m && c < n) {
				if(M[r++][c++] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			int r = i;
			int c = n-1;
			int count = 0;
			while(r < m && c >= 0) {
				if(M[r++][c--] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			int r = 0;
			int c = j;
			int count = 0;
			while(r < m && c < n) {
				if(M[r++][c++] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			int r = 0;
			int c = j;
			int count = 0;
			while(r < m && c >= 0) {
				if(M[r++][c--] == 1) {
					count++;
					res = Math.max(count, res);
				}else {
					count = 0;
				}
			}
		}
        
		return res;
    }

}

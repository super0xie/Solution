import java.util.ArrayList;
import java.util.Collections;

public class SorttheMatrixDiagonally {
	
	public int[][] diagonalSort(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		
		int[][] res = new int[m][n];
		
		for(int i = m-1; i >= 0; i--) {
			int r = i;
			int c = 0;
			ArrayList<Integer> l = new ArrayList<>();
			while(r < m && c < n)
				l.add(mat[r++][c++]);
			
			Collections.sort(l);
			
			int idx = 0;
			r = i;
			c = 0;
			while(r < m && c < n)
				res[r++][c++] = l.get(idx++);
		}
		
		for(int j = 1; j < n; j++) {
			int r = 0;
			int c = j;
			ArrayList<Integer> l = new ArrayList<>();
			while(r < m && c < n)
				l.add(mat[r++][c++]);
			
			Collections.sort(l);
			
			int idx = 0;
			r = 0;
			c = j;
			while(r < m && c < n)
				res[r++][c++] = l.get(idx++);
		}
		
		return res;
    }
	
}

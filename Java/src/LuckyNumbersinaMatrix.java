import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersinaMatrix {
	
	public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rowmin = new int[m];
        Arrays.fill(rowmin, Integer.MAX_VALUE);
        int[] colmax = new int[n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		rowmin[i] = Math.min(rowmin[i], matrix[i][j]);
        		colmax[j] = Math.max(colmax[j], matrix[i][j]);
        	}
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == rowmin[i] && matrix[i][j] == colmax[j]) {
        			res.add(matrix[i][j]);
        		}
        		
        	}
        }
        return res;
    }
	
}

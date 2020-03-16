import java.util.Arrays;

public class TheKWeakestRowsinaMatrix {
	
	public int[] kWeakestRows(int[][] mat, int k) {
		int n = mat.length;
		int c = mat[0].length;
        Integer[] arr = new Integer[n];
        int[] count = new int[n];
        
        for(int i = 0; i < n; i++) {
        	int num = 0;
        	for(int j = 0; j < c; j++) 
        		if(mat[i][j] == 1) num++;
        	count[i] = num;
        }
        
        for(int i = 0; i < n; i++) arr[i] = i;
        
        Arrays.sort(arr, (a, b)->{
        	if(count[a] != count[b]) {
        		return count[a] - count[b];
        	}else {
        		return a - b;
        	}
        	
        });
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = arr[i];
        return res;
        
    }
	
}

import java.util.HashMap;

public class ImageOverlap {
	
	public int largestOverlap(int[][] A, int[][] B) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0 ; i < A.length; i++) {
        	for(int j = 0; j < A.length; j++) {
        		if(A[i][j] == 1) {
        			for(int m = 0; m < A.length; m++) {
        				for(int n = 0; n < A.length; n++) {
        					if(B[m][n] == 1) {
        						String key = "" + (i-m) + "," + (j-n);
        						map.put(key, map.getOrDefault(key, 0)+1);
        					}
        				}
        			}
        		}        		
        	}
        }
        int res = 0;
        for(int v : map.values()) {
        	res = Math.max(res, v);
        }
        return res;
    }

}

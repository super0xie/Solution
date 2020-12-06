import java.util.ArrayList;

public class MaximalNetworkRank {
	
	public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] mat = new boolean[n][n];
        for(int[] r : roads) {
        	count[r[0]]++;
        	count[r[1]]++;
        	mat[r[0]][r[1]] = true;
        	mat[r[1]][r[0]] = true;
        }
        int m = Integer.MIN_VALUE;
        ArrayList<Integer> l = new ArrayList<>();
        for(int i : count) m = Math.max(m, i);
        int res = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = i+1; j < n; j++) {
        		if(mat[i][j]) {
        			res = Math.max(res, count[i]+count[j]-1);
        		}else {
        			res = Math.max(res, count[i]+count[j]);
        		}
        	}
        }
        return res;
    }
	
}

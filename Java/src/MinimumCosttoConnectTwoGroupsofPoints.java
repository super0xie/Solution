import java.util.Arrays;
import java.util.List;

public class MinimumCosttoConnectTwoGroupsofPoints {
	
	public int connectTwoGroupsDP(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        int[][] c = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		c[i][j] = cost.get(i).get(j);
        	}
        }
        
        int total = 1 << n;
        int[][] dp = new int[m][total];
        
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        
        for(int i = 0; i < m; i++) {
        	for(int j = 1; j < total; j++) {
        		int sum = 0;
        		int aux = j;
        		int idx = 0;
        		while(aux > 0) {
        			if(aux % 2 == 1) sum += c[i][idx];
        			idx++;
        			aux = aux >> 1;
        		}
        		if(i == 0) dp[i][j] = sum;
        		else {
        			for(int k = 1; k < total; k++) {
            			int nbm = k | j;
            			dp[i][nbm] = Math.min(dp[i][nbm], dp[i-1][k]+sum);
            		}
        		}
        	}
        }
        
        
        return dp[m-1][total-1];
    }
	
	
	private int m;
	private int n;
	private int[][] c;
	private int[] min;
	public int connectTwoGroupsDFS(List<List<Integer>> cost) {
        m = cost.size();
        n = cost.get(0).size();
        c = new int[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		c[i][j] = cost.get(i).get(j);
        	}
        }
        min = new int[n];
        for(int i = 0; i < n; i++) {
        	min[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < m; j++) min[i] = Math.min(min[i], c[j][i]);
        }
        
        int total = 1 << n;
        int[][] dp = new int[m+1][total];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        return dfs(0, 0, dp);
    }
	
	private int dfs(int i, int bm, int[][] cache) {
		if(cache[i][bm] != Integer.MAX_VALUE) return cache[i][bm];
		
		if(i == m) {
			int res = 0;
			for(int j = 0; j < n; j++) {
				if((bm & (1 << j)) == 0) res += min[j];
			}
			cache[i][bm] = res;
		}else {
			for(int j = 0; j < n; j++) {
				cache[i][bm] = Math.min(cache[i][bm], c[i][j] + dfs(i+1, bm | (1 << j), cache));
			}
		}
		return cache[i][bm];
	}
	
	public int connectTwoGroups(int[][] c) {
        m = c.length;
        n = c[0].length;
        this.c = c;
        min = new int[n];
        for(int i = 0; i < n; i++) {
        	min[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < m; j++) min[i] = Math.min(min[i], c[j][i]);
        }
        
        int total = 1 << n;
        int[][] dp = new int[m+1][total];
        for(int i = 0; i <= m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        int res = dfs(0, 0, dp);
        return res;
    }
	
	
	
	public static void main(String[] args) {
		MinimumCosttoConnectTwoGroupsofPoints test = new MinimumCosttoConnectTwoGroupsofPoints();
		int[][] c = {{2, 5, 1}, {3, 4, 7}, {8, 1, 2}, {6, 2, 4}, {3, 8, 8}};
//		int[][] c = {{15, 96}, {36, 2}};
//		int[][] c = {{1,3,5},{4,1,1},{1,5,3}};
		System.out.print(test.connectTwoGroups(c));
	}
	
}

import java.util.Arrays;
import java.util.HashMap;

public class PaintHouseIII {
	
//	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int k = target + 1;
//        if(houses[0] != 0) {
//        	int encode = houses[0] * k + 1;
//        	map.put(encode, 0);
//        }else {
//        	for(int i = 0; i < cost[0].length; i++) {
//        		int encode = (i+1) * k + 1;
//        		map.put(encode, cost[0][i]);
//        	}
//        }
//        
//        for(int i = 1; i < m; i++) {
//        	HashMap<Integer, Integer> aux = new HashMap<>();
//        	
//        	if(houses[i] != 0) {
//        		for(int key : map.keySet()) {
//        			int color = key / k;
//        			int nei = key % k;
//        			int co = map.get(key);
//        			int c = houses[i];
//        			int nn = nei;
//        			if(color != c) nn++;
//        			if(nn > target) continue;
//        			int encode = c * k + nn;
//    				aux.put(encode, Math.min(co, aux.getOrDefault(encode, Integer.MAX_VALUE)));
//    				
//        		}
//        	}else {
//        		for(int key : map.keySet()) {
//        			int color = key / k;
//        			int nei = key % k;
//        			int co = map.get(key);
//        			
//        			for(int c = 1; c <= n; c++) {
//        				int nn = nei;
//        				if(color != c) nn++;
//        				if(nn > target) continue;
//        				int encode = c * k + nn;
//        				aux.put(encode, Math.min(co+cost[i][c-1], aux.getOrDefault(encode, Integer.MAX_VALUE)));
//        			}
//        		}
//        	}
//        	
//        	map = aux;
//        }
//        
//        int res = Integer.MAX_VALUE;
//        for(int key : map.keySet()) {
//        	int nei = key % k;
//        	if(nei == target) {
//        		res = Math.min(res, map.get(key));
//        	}
//        }
//        if(res == Integer.MAX_VALUE) return -1;
//        return res;
//    }
	
	//O(m * n^2 * target)
	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        
        if(houses[0] != 0) {
        	dp[houses[0]][1] = 0;
        }else {
        	for(int i = 0; i < cost[0].length; i++) {
        		dp[i+1][1] = cost[0][i];
        	}
        }
        
        for(int i = 1; i < m; i++) {
        	int[][] aux = new int[n+1][target+1];
            for(int j = 0; j < aux.length; j++) Arrays.fill(aux[j], Integer.MAX_VALUE);
        	
        	if(houses[i] != 0) {
        		for(int color = 1; color < dp.length; color++) {
        			for(int nei = 1; nei <= target; nei++) {
        				int co = dp[color][nei];
        				if(co == Integer.MAX_VALUE) continue;
        				int c = houses[i];
        				int nn = nei;
        				if(color != c) nn++;
        				if(nn > target) continue;
        				aux[c][nn] = Math.min(aux[c][nn], co);
        			}
        		}
        		
        	}else {
        		
        		for(int color = 1; color < dp.length; color++) {
        			for(int nei = 1; nei <= target; nei++) {
        				int co = dp[color][nei];
        				if(co == Integer.MAX_VALUE) continue;
        				for(int c = 1; c <= n; c++) {
            				int nn = nei;
            				if(color != c) nn++;
            				if(nn > target) continue;
            				aux[c][nn] = Math.min(co+cost[i][c-1], aux[c][nn]);
            			}
        			}
        		}
        		
        	}
        	
        	dp = aux;
        }
        
        int res = Integer.MAX_VALUE;
        for(int color = 1; color < dp.length; color++) {
			if(dp[color][target] == Integer.MAX_VALUE) continue;
			res = Math.min(dp[color][target], res);
		}
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
	
	public static void main(String[] args) {
		PaintHouseIII test = new PaintHouseIII();
		int[] houses = {3,1,2,3};
		int[][] cost = {{1,1,1},{1,1,1},{1,1,1},{1,1,1}};
		System.out.print(test.minCost(houses, cost, 4, 3, 3));
	}
	
}

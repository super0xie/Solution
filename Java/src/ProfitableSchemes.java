import java.util.HashMap;
import java.util.TreeMap;

public class ProfitableSchemes {
	
	public int profitableSchemesOld(int G, int P, int[] group, int[] profit) {
		int mod = 1000000007;
        HashMap<Integer, Integer>[] dp = new HashMap[G+1];
        for(int i = 0; i < dp.length; i++) dp[i] = new HashMap<>();
        dp[0].put(0, 1);
        
        int n = group.length;
        
        for(int i = 0; i < n; i++) {
        	for(int j = G; j-group[i] >= 0; j--) {
        		for(int p : dp[j-group[i]].keySet()) {
        			int np = dp[j].getOrDefault(p+profit[i], 0) + dp[j-group[i]].get(p);
        			np = np % mod;
        			dp[j].put(p+profit[i], np);
        		}
        	}
        }
        
        int res = 0;
        for(int i = 0; i < dp.length; i++) {
        	for(int key : dp[i].keySet()) {
        		if(key >= P) {
        			res += dp[i].get(key);
        			res = res % mod;
        		}
        	}
        }
        
        return res;
    }
	
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		int mod = 1000000007;
        int[][] dp = new int[G+1][P+1];
        
        dp[0][0] = 1;
        
        int n = group.length;
        
        for(int i = 0; i < n; i++) {
        	for(int j = G; j-group[i] >= 0; j--) {
        		
        		for(int k = 0; k <= P; k++) {
        			int np = k + profit[i];
        			if(np > P) np = P;
        			dp[j][np] += dp[j-group[i]][k];
        			dp[j][np] = dp[j][np] % mod;
        		}
        		
        	}
        }
        
        int res = 0;
        for(int i = 0; i < dp.length; i++) {
        	res += dp[i][P];
        	res = res % mod;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		ProfitableSchemes test = new ProfitableSchemes();
		int[] group = {6,3,6,1,10,1,11,6,8,8,11,10,9,10,4,7,9,6,7,9,10,8,4,6,7,7,9,4,4,4,8,6,7,10,5,2,1,6,11,3,8,9,3,2,8,4,7,10,9,5,3,6,10,4,5,4,10,3,8,6,11,10,6,9,8,11,3,7,2,7,7,9,7,10,1,3,3,9,6,3,11,3,5,10,9,4,10,6,4,10,9,2,1,1,9,10,5,10,7,6};
		int[] profit = {2,0,0,1,2,0,0,1,2,1,1,2,2,2,1,0,2,2,1,1,0,0,2,2,0,2,2,2,0,1,2,1,1,0,0,2,2,2,2,0,0,0,0,2,0,0,1,0,2,1,0,2,0,0,1,2,2,1,1,2,1,1,2,0,2,0,0,1,1,1,0,1,1,2,2,1,0,0,1,0,2,2,1,2,2,0,0,2,0,2,2,1,0,2,0,1,0,1,0,2};
		
		System.out.println(test.profitableSchemes(10, 1, group, profit));
		
	}
}

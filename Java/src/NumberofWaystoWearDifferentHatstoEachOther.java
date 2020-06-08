import java.util.Arrays;
import java.util.List;

public class NumberofWaystoWearDifferentHatstoEachOther {
	
	public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int max = (int)Math.pow(2, n)-1;
        int mod = 1000000007;
        long[][] dp = new long[41][max+1];
        boolean[][] p = new boolean[41][n];
        for(int i = 0; i < n; i++) {
        	for(int j : hats.get(i)) p[j][i] = true;
        }
        
        
        for(int i = 1; i <= 40; i++) {
        	for(int j = 1; j <= max; j++) {
        		dp[i][j] += dp[i-1][j];
        		int mask = 1;
        		for(int k = 0; k < n; k++, mask = mask << 1) {
        			if(p[i][k]) {
        				if((j & mask) == 0) continue;
        				int a = j & (~mask);
        				if(a == 0) dp[i][j] += 1;
        				else dp[i][j] += dp[i-1][a];
        				
        				dp[i][j] = dp[i][j] % mod;
        			}
        		}
        	}
        }
        
        return (int)dp[40][max];
    }
	
	public static void main(String[] args) {
		NumberofWaystoWearDifferentHatstoEachOther test = new NumberofWaystoWearDifferentHatstoEachOther();
		System.out.println(test.numberWays(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(2,3,5,6), Arrays.asList(1,3,7,9), Arrays.asList(1,8,9), Arrays.asList(2,5,7))));
	}
	
}

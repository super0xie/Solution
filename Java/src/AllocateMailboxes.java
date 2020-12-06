import java.util.Arrays;

public class AllocateMailboxes {
	
	public int minDistance(int[] houses, int k) {
		int n = houses.length;
        int[][] dp = new int[n][k];
        Arrays.parallelSort(houses);
        dp[1][0] = houses[1]-houses[0];
        
        for(int i = 2; i < n; i++) {
        	for(int j = 0; j < k; j++) {
        		if(j >= i) continue;
        		
        		if(j == 0) {
        			int m = houses[i/2];
        			int sum = 0;
        			for(int l = 0; l <= i; l++) sum += Math.abs(houses[l] - m);
        			dp[i][j] = sum;
        		} else {
        			dp[i][j] = dp[i-1][j-1];
        			for(int l = i-1; l >= j; l--) {
        				int m = houses[l + (i-l)/2];
        				int sum = 0;
        				for(int o = l; o <= i; o++) sum += Math.abs(houses[o]-m);
        				dp[i][j] = Math.min(dp[i][j], sum + dp[l-1][j-1]);
        			}
        		}
        	}
        }
        
        return dp[n-1][k-1];
    }
	
	public static void main(String[] args) {
		int[] houses = {3,6,14,10};
		int k = 4;
		AllocateMailboxes test = new AllocateMailboxes();
		System.out.println(test.minDistance(houses, k));
	}
	
}

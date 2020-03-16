import java.util.Arrays;

public class MinimumNumberofTapstoOpentoWateraGarden {
	
	public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 0; i <= n; i++) {
        	if(ranges[i] == 0) continue;
        	
        	int l = i - ranges[i];
        	l = Math.max(l, 0);
        	int r = i + ranges[i];
        	r = Math.min(r, n);
        	
        	int min = Integer.MAX_VALUE;
        	if(l == 0) {
        		min = 1;
        		for(int j = l; j <= r; j++) {
        			dp[j] = 1;
        		}
        	} else {
        		for(int j = l; j <= r; j++) 
        			min = Math.min(min, dp[j]);
        		
        		if(min == Integer.MAX_VALUE) continue;
        		for(int j = l; j <= r; j++) 
        			dp[j] = Math.min(min+1, dp[j]);
        		
        	}
        }
        
        if(dp[n] == Integer.MAX_VALUE) return -1;
        return dp[n];
    }
	
	public static void main(String[] args) {
		MinimumNumberofTapstoOpentoWateraGarden test = new MinimumNumberofTapstoOpentoWateraGarden();
		System.out.println(test.minTaps(8, new int[] {4,0,0,0,4,0,0,0,4}));
	}
	
}

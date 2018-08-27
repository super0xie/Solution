
public class PerfectSquares {
	
    public int numSquares(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if(n == 1) return 1;
        
        double sqrt = Math.sqrt(n);
        if(sqrt - (int)sqrt == 0.0) return 1;
        
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
        	sqrt = Math.sqrt(i+1);
            if(sqrt - (int)sqrt == 0.0) {
            	dp[i] = 1;
            	continue;
            }
            
        	int min = Integer.MAX_VALUE;
        	int start = 0;
        	int end = i-1;
        	while(start <= end) {
        		if(dp[start] + dp[end] < min) min = dp[start] + dp[end];
        		if(min == 2) break;
        		start++;
        		end--;
        	}
        	
        	dp[i] = min;
        }
        
        
        return dp[n-1]; 
    }
    
    public static void main(String[] args) {
    	PerfectSquares test = new PerfectSquares();
    	System.out.println(test.numSquares(7));
    }
    
}

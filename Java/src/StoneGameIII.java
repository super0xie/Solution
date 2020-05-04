
public class StoneGameIII {
	
	public String stoneGameIII(int[] s) {

		int n = s.length;
        int[] dp = new int[n];
        dp[n-1] = s[n-1];
        int sum = s[n-1];
        if(n-2 >= 0) {
        	dp[n-2] = Math.max(s[n-2], s[n-1]+s[n-2]);
        	sum += s[n-2];
        }
        if(n-3 >= 0) {
        	dp[n-3] = Integer.MIN_VALUE;
        	dp[n-3] = Math.max(dp[n-3], s[n-3] + sum-dp[n-2]);
        	dp[n-3] = Math.max(dp[n-3], s[n-3]+s[n-2]);
        	dp[n-3] = Math.max(dp[n-3], s[n-3] + s[n-2] + s[n-1]);
        	
        	
        	sum += s[n-3];
        }
        	
        
        for(int i = n-4; i >= 0; i--) {
        	dp[i] = Integer.MIN_VALUE;
        	dp[i] = Math.max(dp[i], s[i] + sum-dp[i+1]);
        	dp[i] = Math.max(dp[i], s[i] + s[i+1] + sum-s[i+1]-dp[i+2]);
        	dp[i] = Math.max(dp[i], s[i] + s[i+1] + s[i+2] + sum-s[i+1]-s[i+2]-dp[i+3]);
        	
        	sum += s[i];
        }
        
        if(dp[0] > sum-dp[0]) return "Alice";
        else if(dp[0] < sum-dp[0]) return "Bob";
        else return "Tie";
    }
	
	public static void main(String[] args) {
		StoneGameIII test = new StoneGameIII();
		int[] s = new int[] {1,2,3,7};
		System.out.println(test.stoneGameIII(s));
	}
	
}

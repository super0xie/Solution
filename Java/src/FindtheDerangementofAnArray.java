
public class FindtheDerangementofAnArray {
	

	public int findDerangement(int n) {
		if(n == 1) return 0;
		if(n == 2) return 1;
		int mod = 1000000007;
		int[] dp = new int[n+1];
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (int)(((i-1L) * (dp[i-1] + dp[i-2]))%mod);
		}
        return dp[n];
    }
	
	public static void main(String[] args) {
		FindtheDerangementofAnArray test = new FindtheDerangementofAnArray();
		System.out.println(test.findDerangement(4));
	}
}

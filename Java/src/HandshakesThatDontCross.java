
public class HandshakesThatDontCross {
	
	public int numberOfWays(int num_people) {
        long[] dp = new long[num_people+1];
        dp[2] = 1;
        dp[0] = 1;
        int mod = 1000000007;
        
        for(int i = 4; i <= num_people; i+=2) {
        	for(int j = 2; j <= i; j++) {
        		int l = j - 2;
        		int r = i - l - 2;
        		dp[i] += dp[l] * dp[r];
        		dp[i] = dp[i] % mod;
        	}
        }
        
        return (int)dp[num_people];
    }
	
	public static void main(String[] args) {
		HandshakesThatDontCross test = new HandshakesThatDontCross();
		System.out.println(test.numberOfWays(140));
	}
	
}

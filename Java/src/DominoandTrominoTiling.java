
public class DominoandTrominoTiling {
    
    public int numTilingsOld(int N) {
        int mod = 1000000000+7;
        long[][] dp = new long[N+1][4];
        
        dp[0][3] = 1;
        
        for(int i = 1; i <= N; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod;
            dp[i][3] = (dp[i-1][0] + dp[i-1][3]) % mod;
        }
        
        return (int)dp[N][3];
    }

    public int numTilings(int N) {
        int mod = 1000000000+7;
        long[][] dp = new long[N+1][4];
        
        dp[1][3] = 1;
        dp[1][0] = 1;
        
        for(int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod;
            dp[i][3] = dp[i-1][0];
        }
        
        return (int)dp[N][0];
    }

    public static void main(String[] args) {
        DominoandTrominoTiling test = new DominoandTrominoTiling();
        System.out.print(test.numTilings(3));
    }
    
    
}

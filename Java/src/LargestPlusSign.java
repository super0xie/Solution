import java.util.HashSet;

public class LargestPlusSign {
    
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        HashSet<String> set = new HashSet<String>();
        
        for(int i = 0; i < mines.length; i++) {
            String str = "" +  mines[i][0] * N + mines[i][1];
            set.add(str);
        }
        
        int[][] dp = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            int count = 0;
            for(int j = 0; j < N; j++) {
                String str = "" +  i * N + j;
                if(set.contains(str)) count = 0;
                else count++;
                dp[i][j] = count;
            }
            count = 0;
            for(int j = N-1; j >=0; j--) {
                if(dp[i][j] == 0) count = 0;
                else count++;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
        }
        
        int res = Integer.MIN_VALUE;
        
        for(int j = 0; j < N; j++) {
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(dp[i][j] == 0) count = 0;
                else count++;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
            count=0;
            for(int i = N-1; i >= 0; i--) {
                if(dp[i][j] == 0) count = 0;
                else count++;
                dp[i][j] = Math.min(count, dp[i][j]);
                
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res;
    }

}

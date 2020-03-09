import java.util.Arrays;

public class LargestMultipleofThree {
    
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        Integer[] d = new Integer[n];
        for(int i = 0; i < n; i++) d[i] = digits[i];
        Arrays.sort(d, (a, b)->{return b-a;});
        
        if(d[0] == 0) return "0";
        
        String[][] dp = new String[3][n];
        int idx = d[0] % 3;
        dp[idx][0] = "" + d[0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                if(dp[j][i-1] == null) {
                    if(dp[d[i]%3][i] == null) dp[d[i]%3][i] = "" + d[i];
                }else {
                    int tidx = (j + d[i]) % 3;
                    int olen = 0;
                    if(dp[tidx][i-1] != null) olen = dp[tidx][i-1].length();
                    if(dp[j][i-1].length()+1 != olen) {
                        if(dp[j][i-1].length()+1 > olen) {
                            dp[tidx][i] = dp[j][i-1] + d[i];
                        }else {
                            dp[tidx][i] = dp[tidx][i-1];
                        }
                    }else {
                        String aux = dp[j][i-1] + d[i];
                        dp[tidx][i] = max(aux, dp[tidx][i-1]);
                    }
                }
                
                if(dp[j][i] == null) dp[j][i] = dp[j][i-1];
            }
        }
        if(dp[0][n-1] == null) return "";
        return dp[0][n-1];
    }
    
    private String max(String a, String b) {
        if(b == null) return a;
        if(a.compareTo(b) >= 0) return a;
        return b;
    }
    
    public static void main(String[] args) {
        LargestMultipleofThree test = new LargestMultipleofThree();
        int[] digits = {0,0,0,0,0,0};
        System.out.println(test.largestMultipleOfThree(digits));
    }
    
    
    
}

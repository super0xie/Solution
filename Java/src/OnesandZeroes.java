
public class OnesandZeroes {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(String str : strs) {
            int countZero = 0;
            int countOne = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0') countZero++;
                else if(str.charAt(i) == '1') countOne++;
            }
            
            for(int i = m; i >= countZero; i--) {
                for(int j = n; j >= countOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-countZero][j-countOne]+1);
                }
            }
            
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        OnesandZeroes test = new OnesandZeroes();
        String[] strs = {"10","0001","111001","1","0"};
        test.findMaxForm(strs, 5, 3);
    }
    
}

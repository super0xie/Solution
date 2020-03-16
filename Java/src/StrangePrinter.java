public class StrangePrinter{

    public int strangePrinter(String s) {
        if(s.length() == 0) return 0;
        
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(j) == s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    int res = dp[i][j-1] + 1;
                    int k = j-1;
                    for(; k >= i; k--){
                        if(s.charAt(k) == s.charAt(j)) res = Math.min(res, dp[i][k] + dp[k+1][j-1]);
                    }

                    dp[i][j] = res;
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        StrangePrinter test = new StrangePrinter();
        System.out.println(test.strangePrinter("dddccbdbababaddcbcaabdbdddcccddbbaabddb"));
    }



}




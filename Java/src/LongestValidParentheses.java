public class LongestValidParentheses{

    public int longestValidParenthesesBF(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int l = 0;
            int r = 0;

            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '(') l++;
                else r++;

                if(r > l) break;
                if(l == r) res = Math.max(res, l+r);
            }
        }
        return res;
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int[] dp = new int[s.length()];

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '(') dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                else{
                    if(dp[i-1] > 0 && i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = dp[i-1] + 2;
                        if(i-dp[i-1]-2 >= 0 && dp[i-dp[i-1]-2] > 0) dp[i] += dp[i-dp[i-1]-2];
                    }
                }

                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses("()(())"));
    }

}
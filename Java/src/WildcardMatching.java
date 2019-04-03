public class WildcardMatching {

    public boolean isMatchTLE(String s, String p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*'){
                while(i < p.length()-1 && p.charAt(i+1) == '*') i++;
                sb.append('*');
            }else{
                sb.append(p.charAt(i));
            }
        }
        p = sb.toString();

        return helper(s, p, 0, 0);
    }

    private boolean helper(String s, String p, int i, int j){
        if(i == s.length() && j == p.length()) return true;
        if(i != s.length() && j == p.length()) return false;
        if(p.charAt(j) == '*'){
            for(int k = i; k <= s.length(); k++){
                if(helper(s, p, k, j+1)) return true;
            }
            return false;
        }else if(p.charAt(j) == '?'){
            if(i == s.length()) return false;
            return helper(s, p, i+1, j+1);
        }else{
            if(i == s.length()) return false;
            if(s.charAt(i) != p.charAt(j)) return false;
            return helper(s, p, i+1, j+1);
        }
    }

    public boolean isMatchOld(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if(s.length() != 0 && p.length() == 0) return false;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*'){
                while(i < p.length()-1 && p.charAt(i+1) == '*') i++;
                sb.append('*');
            }else{
                sb.append(p.charAt(i));
            }
        }
        p = sb.toString();
        
        if(s.length() == 0 && p.length() != 0) {
            if(p.equals("*")) return true;
            else return false;
        }
        
        boolean[][] dp = new boolean[s.length()][p.length()];
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == '?'){
                    if(i == 0 && j == 0) dp[i][j] = true;
                    else if(i > 0 && j > 0 && dp[i-1][j-1]) dp[i][j] = true;
                    else if(i == 0 && j == 1 && p.charAt(0) == '*') dp[i][j] = true;
                }else if(p.charAt(j) == '*'){
                    if(j == 0) dp[i][j] = true;
                    else{
                        for(int k = i; k >= 0; k--){
                            if(dp[k][j-1]){
                                dp[i][j] = true;
                                break;
                            }
                        }
                    }
                }else{
                    if(s.charAt(i) == p.charAt(j)){
                        if(i == 0 && j == 0) dp[i][j] = true;
                        else if(i > 0 && j > 0 && dp[i-1][j-1]) dp[i][j] = true;
                        else if(i == 0 && j == 1 && p.charAt(0) == '*') dp[i][j] = true;
                    }
                }
            }
        }

        return dp[s.length()-1][p.length()-1];
    }
    
    public boolean isMatch(String s, String p) {
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '*'){
                while(i < p.length()-1 && p.charAt(i+1) == '*') i++;
                sb.append('*');
            }else{
                sb.append(p.charAt(i));
            }
        }
        p = sb.toString();
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        if(p.length() > 0 && p.charAt(0) == '*') {
            for(int i = 0; i <= s.length(); i++) dp[i][1] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == '?'){
                    if(dp[i][j]) dp[i+1][j+1] = true;
                }else if(p.charAt(j) == '*'){
                    for(int k = i+1; k >= 0; k--){
                        if(dp[k][j]){
                            dp[i+1][j+1] = true;
                            break;
                        }
                    }
                }else{
                    if(s.charAt(i) == p.charAt(j)){
                        if(dp[i][j]) dp[i+1][j+1] = true;
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }



    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        System.out.println(test.isMatch("adceb", "*a*b"));
    }



}

public class MinimumWindowSubsequence {
    
    public String minWindow(String S, String T) {
        int[][] dp = new int[S.length()][T.length()];
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
            }else {
                if(i == 0) dp[i][0] = -1;
                else dp[i][0] = dp[i-1][0];
            }
        }
        
        for(int i = 0; i < S.length(); i++) {
            for(int j = 1; j < T.length(); j++) {
                if(i < j) {
                    dp[i][j] = -1;
                    continue;
                }
                
                if(S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        int min = Integer.MAX_VALUE;
        String res = "";
        
        for(int i = 0; i < S.length(); i++) {
            if(dp[i][T.length()-1] != -1) {
                if(i - dp[i][T.length()-1] + 1 < min) {
                    min = i - dp[i][T.length()-1]+1;
                    res = S.substring(dp[i][T.length()-1], i+1);
                }
                
            }
            
        }
        
        return res;
    }
    
    public String minWindowTLE(String S, String T) {
        int [] tar = new int[26];
        int [] src = new int[26];
        String res = "";
        for(int i = 0; i < T.length(); i++) {
            tar[T.charAt(i)-'a']++;
        }
        
        int i = 0;
        int j = 0;
        src[S.charAt(i)-'a']++;
        int min = Integer.MAX_VALUE;
        while(i <= j && j < S.length()) {
            if(j-i+1 >= T.length()) {
                if(candidate(src, tar)) {
                    if(isSubsequence(T, S.substring(i, j+1))) {
                        if(j-i+1 < min) {
                            res = S.substring(i, j+1);
                            min = j-i+1;
                        }
                        src[S.charAt(i)-'a']--;
                        i++;
                    }else {
                        j++;
                        if(j < S.length()) src[S.charAt(j)-'a']++;
                    }
                }else {
                    j++;
                    if(j < S.length()) src[S.charAt(j)-'a']++;
                    
                }
            }else {
                j++;
                if(j < S.length()) src[S.charAt(j)-'a']++;
                
            }
        }
        
        return res;
    }
    
    private boolean candidate(int[] src, int[] tar) {
        for(int i = 0; i < 26; i++) {
            if(src[i] < tar[i]) return false;
        }
        return true;
    }
    
    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i < s.length() && s.charAt(i) == c) i++;
        }
        if(i == s.length()) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        MinimumWindowSubsequence test = new MinimumWindowSubsequence();
        System.out.println(test.minWindow("abcdebdde", "bde"));
    }
}

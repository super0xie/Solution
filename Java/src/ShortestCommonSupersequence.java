public class ShortestCommonSupersequence{

    public String shortestCommonSupersequenceOld(String str1, String str2) {
        String[][] dp = new String[str1.length()][str2.length()];

        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(i == 0 || j == 0) dp[i][j] = "" + str1.charAt(i);
                    else dp[i][j] = dp[i-1][j-1] + str1.charAt(i);
                }else{
                    dp[i][j] = "";
                    if(i > 0 && dp[i-1][j].length() > dp[i][j].length()) dp[i][j] = dp[i-1][j];
                    if(j > 0 && dp[i][j-1].length() > dp[i][j].length()) dp[i][j] = dp[i][j-1];
                }
            }
        }

        String lcs = dp[str1.length()-1][str2.length()-1];

        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int k = 0; k < lcs.length(); k++){
            while(str1.charAt(i) != lcs.charAt(k)) sb.append(str1.charAt(i++));
            while(str2.charAt(j) != lcs.charAt(k)) sb.append(str2.charAt(j++));

            sb.append(lcs.charAt(k));
            i++;
            j++;
        }

        while(i < str1.length()) sb.append(str1.charAt(i++));
        while(j < str2.length()) sb.append(str2.charAt(j++));

        return sb.toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String[][] dp = new String[str1.length()+1][str2.length()+1];

        for(int i = 0; i <= str1.length(); i++) dp[i][0] = str1.substring(0, i);
        for(int j = 0; j <= str2.length(); j++) dp[0][j] = str2.substring(0, j);

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                }else{
                    if(dp[i-1][j].length() <= dp[i][j-1].length()) dp[i][j] = dp[i-1][j] + str1.charAt(i-1);
                    else dp[i][j] = dp[i][j-1] + str2.charAt(j-1);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence test = new ShortestCommonSupersequence();
        System.out.print(test.shortestCommonSupersequence("abac", "cab"));
    }



}
import java.util.ArrayList;

public class PalindromePartitioningII {

    public int minCutOld(String s) {
        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = i; j >= 0; j--){
                if(isPlaindrome(s, j, i)){
                    if(j == 0) dp[i] = Math.min(dp[i], 1);
                    else dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1]-1;
    }

    private boolean isPlaindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public int minCut(String s) {
        ArrayList<Integer>[] pairs = new ArrayList[s.length()];
        for(int i = 0; i < pairs.length; i++) pairs[i] = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            pairs[i].add(i);
            int l = i-1;
            int r = i+1;
            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    if(pairs[r].add(l));
                }else{
                    break;
                }
                l--;
                r++;
            }

            l = i;
            r = i+1;

            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    if(pairs[r].add(l));
                }else{
                    break;
                }
                l--;
                r++;
            }
        }

        int[] dp = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i] = Integer.MAX_VALUE;

            for(int j : pairs[i]){
                if(j == 0) dp[i] = Math.min(dp[i], 1);
                else dp[i] = Math.min(dp[i], dp[j-1]+1);
            }
        }
        return dp[s.length()-1]-1;
    }

    public static void main(String[] args) {
        PalindromePartitioningII test = new PalindromePartitioningII();
        System.out.println(test.minCut("a"));
    }

}
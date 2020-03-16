public class LongestChunkedPalindromeDecomposition{

    public int longestDecompositionOld(String text) {
        int start = text.length() / 2;
        int[] dp = new int[text.length()-start];

        for(int i = 0; i + start < text.length(); i++){
            int cur = i + start;
            dp[i] = 1;
            for(int j = cur; j >= start; j--){
                int l = j;
                int r = cur;
                int or = text.length()-1-l;
                int ol = text.length()-1-r;

                if(or >= l) break;

                String right = text.substring(l, r+1);
                String left = text.substring(ol, or+1);

                if(left.equals(right)){
                    if(j == start){
                        dp[i] = Math.max(dp[i], 2);
                    }else{
                        dp[i] = Math.max(dp[i], dp[j-1-start]+2);
                    }
                }
            }
        }
        return dp[text.length()-start-1];
    }

    public int longestDecomposition(String text) {
        int start = text.length() / 2;
        int[] dp = new int[text.length()-start];

        for(int i = 0; i + start < text.length(); i++){
            int cur = i + start;
            dp[i] = 1;
            for(int j = cur; j >= start; j--){
                int l = j;
                int r = cur;
                int or = text.length()-1-l;
                int ol = text.length()-1-r;

                if(or >= l) break;
                int target = 0;
                if(j == start) target = 2;
                else target = dp[j-1-start]+2;

                if(target > dp[i]){
                    if(helper(text, l, ol, r)) dp[i] = target;
                }
            }
        }
        return dp[text.length()-start-1];
    }

    private boolean helper(String str, int l, int ol, int r){
        for(int i = 0; l + i <= r; i++){
            if(str.charAt(l+i) != str.charAt(ol+i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestChunkedPalindromeDecomposition test = new LongestChunkedPalindromeDecomposition();
        System.out.println(test.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
    }

}
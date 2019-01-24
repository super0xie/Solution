
public class UniqueBinarySearchTrees {
    
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int res = 0;
            for(int j = 0; j < i; j++) {
                int l = j;
                int r = i - j - 1;
                res += dp[l] * dp[r];
            }
            dp[i] = res;
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
        System.out.println(test.numTrees(8));
    }
    
}

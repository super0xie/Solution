public class MinimumCostTreeFromLeafValues{

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];

        for(int i = 0; i < n; i++) max[i][i] = arr[i];

        for(int k = 2; k <= n; k++){
            for(int i = 0; i + k - 1 < n; i++){
                int j = i + k -1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int m = i; m < j; m++){
                    int aux = dp[i][m] + dp[m+1][j] + max[i][m] * max[m+1][j];
                    dp[i][j] = Math.min(dp[i][j], aux);
                }
                max[i][j] = Math.max(max[i][i], max[i+1][j]);
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] arr = {6,2,4};
        MinimumCostTreeFromLeafValues test = new MinimumCostTreeFromLeafValues();
        System.out.print(test.mctFromLeafValues(arr));
    }

}
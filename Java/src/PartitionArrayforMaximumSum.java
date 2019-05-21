public class PartitionArrayforMaximumSum{

    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        for(int i = 1; i < n; i++){
            int max = Integer.MIN_VALUE;
            dp[i] = Integer.MIN_VALUE;
            for(int j = i-1; j >= -1 && i-j <= K; j--){
            	max = Math.max(max, A[j+1]);
            	if(j < 0) {
            		dp[i] = Math.max(dp[i], max * (i+1));
            		continue;
            	}
                dp[i] = Math.max(dp[i], dp[j] + max * (i-j));
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        PartitionArrayforMaximumSum test = new PartitionArrayforMaximumSum();
        int[] A = {1,15,7,9,2,5,10};
        System.out.print(test.maxSumAfterPartitioning(A, 3));
    }


}
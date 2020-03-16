public class LargestSumofAverages{

    public double largestSumOfAverages(int[] A, int K) {
        double[][] dp = new double[A.length+1][K+1];
        int s = 0;
        int[] prefixSum = new int[A.length];
        for(int i = 0; i < A.length; i++){
            s += A[i];
            prefixSum[i] = s;
        }

        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= K; j++){
                if(i < j) {
                    dp[i][j] = 0;
                }else if(i == j) {
                    dp[i][j] = sum(0, i-1, prefixSum);
                }else if(j == 1){
                    dp[i][j] = avg(0, i-1, prefixSum);
                }else {
                    double max = Integer.MIN_VALUE;
                    for(int k = j-1; k < i; k++){
                        double sum = dp[k][j-1] + avg(k, i-1, prefixSum);
                        max = Double.max(max, sum);
                    }
                    dp[i][j] = max;
                }
            }
        }

        return dp[A.length][K];
    }
    
    private int sum(int i, int j, int[] prefixSum) {
        int sum = prefixSum[j];
        if(i > 0) sum -= prefixSum[i-1];
        return sum;
    }

    private double avg(int i, int j, int[] prefixSum){
        int sum = sum(i, j, prefixSum);
        return (double)sum/(j-i+1);
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        LargestSumofAverages test = new LargestSumofAverages();
        System.out.print(test.largestSumOfAverages(A, 4));
    }

}
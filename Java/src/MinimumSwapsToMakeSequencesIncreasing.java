public class MinimumSwapsToMakeSequencesIncreasing{

    public int minSwapMem(int[] A, int[] B) {
        int[][] dp = new int[A.length][2];
        dp[0][0] = 1;

        for(int i = 1; i < A.length; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if(B[i] > B[i-1] && A[i] > A[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]+1);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1]);
            }
            if(B[i] > A[i-1] && A[i] > B[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]+1);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0]);
            }
        }

        return Math.min(dp[A.length-1][0], dp[A.length-1][1]);
    }

    public int minSwap(int[] A, int[] B) {
        int[] pre = new int[2];
        pre[0] = 1;

        for(int i = 1; i < A.length; i++){
            int swapEnd = Integer.MAX_VALUE;
            int keepEnd = Integer.MAX_VALUE;
            if(B[i] > B[i-1] && A[i] > A[i-1]) {
                swapEnd = Math.min(swapEnd, pre[0]+1);
                keepEnd = Math.min(keepEnd, pre[1]);
            }
            if(B[i] > A[i-1] && A[i] > B[i-1]) {
                swapEnd = Math.min(swapEnd, pre[1]+1);
                keepEnd = Math.min(keepEnd, pre[0]);
            }
            pre[0] = swapEnd;
            pre[1] = keepEnd;
        }

        return Math.min(pre[0], pre[1]);
    }

    public static void main(String[] args) {
        int[] A = {0,3,5,8,9};
        int[] B = {2,1,4,6,9};
        MinimumSwapsToMakeSequencesIncreasing test = new MinimumSwapsToMakeSequencesIncreasing();
        System.out.print(test.minSwap(A, B));

    }

}
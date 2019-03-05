public class DeleteColumnstoMakeSortedIII{

    public int minDeletionSizeOld(String[] A) {
        int len = A[0].length();
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for(int i = 1; i < len; i++){
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            dp[i][0] = i;
            int j = i-1; 
            for(; j >= 0; j--){
                int k = 0;
                for(; k < A.length; k++){
                    if(A[k].charAt(i) < A[k].charAt(j)) break;
                }
                if(k == A.length) {
                    dp[i][0] = Math.min(dp[i][0], dp[j][0] + i-j-1);
                }
            }

        }
        return Math.min(dp[len-1][0], dp[len-1][1]);
    }

    public int minDeletionSize(String[] A) {
        int len = A[0].length();
        //max length
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;

        for(int i = 1; i < A[0].length(); i++){
            int j = i-1; 
            dp[i] = 1;
            for(; j >= 0; j--){
                int k = 0;
                for(; k < A.length; k++){
                    if(A[k].charAt(i) < A[k].charAt(j)) break;
                }
                if(k == A.length) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return len-maxLen;
    }

    public static void main(String[] args) {
        DeleteColumnstoMakeSortedIII test = new DeleteColumnstoMakeSortedIII();
        String[] A = {"ghi","def","abc"};
        System.out.print(test.minDeletionSize(A));
    }

}
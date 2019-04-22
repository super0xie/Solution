import java.util.Arrays;

public class SplitArrayLargestSum{

    public int splitArrayOld(int[] nums, int m) {
        long[][] dp = new long[nums.length][m+1];
        long max = Long.MAX_VALUE / 2;
        
        int[] prefix = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i] = sum;
            Arrays.fill(dp[i], max);
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= Math.min(i+1, m); j++){
                if(j == 1) {
                    dp[i][j] = sum(prefix, 0, i);
                }else {
                    for(int k = i; k >= 1; k--){
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k-1][j-1], sum(prefix, k, i)));
                    }
                }
            }
        }

        return (int)dp[nums.length-1][m];
    }
    
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m+1];
        
        int[] prefix = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i] = sum;
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= Math.min(i+1, m); j++){
                if(j == 1) {
                    dp[i][j] = sum(prefix, 0, i);
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i; k >= 1; k--){
                        if(dp[k-1][j-1] < 0) break;
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k-1][j-1], sum(prefix, k, i)));
                    }
                }
            }
        }

        return (int)dp[nums.length-1][m];
    }

    private int sum(int[] prefix, int i, int j){
        if(i == 0) return prefix[j];
        else return prefix[j]-prefix[i-1];
    }

    public static void main(String[] args) {
        SplitArrayLargestSum test = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        System.out.println(test.splitArray(nums, 2));
    }

}
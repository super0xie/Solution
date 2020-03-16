public class MaximumProductSubarray{

    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int max = Math.max(Math.max(nums[i], dp[i-1][0] * nums[i]), dp[i-1][1] * nums[i]);
            int min = Math.min(Math.min(nums[i], dp[i-1][0] * nums[i]), dp[i-1][1] * nums[i]);

            dp[i][0] = max;
            dp[i][1] = min;

            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProductMemOpt(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int ma = Math.max(Math.max(nums[i], max * nums[i]), min * nums[i]);
            int mi = Math.min(Math.min(nums[i], max * nums[i]), min * nums[i]);

            max = ma;
            min = mi;

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        MaximumProductSubarray test = new MaximumProductSubarray();
        System.out.print(test.maxProduct(nums));
    }

}
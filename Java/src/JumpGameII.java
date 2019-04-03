import java.util.Arrays;

public class JumpGameII {

    public int jumpDP(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j <= Math.min(nums.length-1, i+nums[i]); j++){
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }

    public int jump(int[] nums) {
        int cur = 0;
        int res = 0;
        while(cur < nums.length-1){
            if(cur + nums[cur] >= nums.length-1){
                res++;
                break;
            }
            int max = Integer.MIN_VALUE;
            int maxIdx = cur;
            for(int i = cur; i <= Math.min(nums.length-1, cur + nums[cur]); i++){
                int sum = i + nums[i];
                if(sum > max){
                    max = sum;
                    maxIdx = i;
                }
            }
            res++;
            cur = maxIdx;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGameII test = new JumpGameII();
        System.out.println(test.jump(nums));
    }

}
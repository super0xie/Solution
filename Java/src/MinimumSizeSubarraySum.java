public class MinimumSizeSubarraySum{

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        int sum = nums[0];

        while(r < nums.length){
            if(sum >= s){
                res = Math.min(res, r-l+1);
                sum -= nums[l];
                l++;
                if(r < l) {
                    r++;
                    if(r < nums.length) sum += nums[r];
                }
                
            }else{
                r++;
                if(r < nums.length) sum += nums[r];
            }
        }
        if(res == Integer.MAX_VALUE) return 0;
        else return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        System.out.print(test.minSubArrayLen(7, nums));
    }

}
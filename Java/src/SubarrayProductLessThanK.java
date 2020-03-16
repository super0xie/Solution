public class SubarrayProductLessThanK{

    public int numSubarrayProductLessThanKOld(int[] nums, int k) {
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            int prod = 1;
            for(int j = i; j < nums.length; j++){
                prod = prod * nums[j];
                if(prod >= k) break;
                res++;
            }
        }

        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0;
        int r = 0;
        int prod = nums[0];
        
        while(l <= r && r < nums.length){
            if(prod < k){
                int len = r-l+1;
                res += len;
                r++;
                if(r < nums.length)
                    prod *= nums[r];
            }else{
                prod = prod / nums[l];
                l++;
                if(l > r){
                    r++;
                    if(r < nums.length)
                    prod *= nums[r];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK test = new SubarrayProductLessThanK();
        int[] nums = {10, 5, 2, 6};
        System.out.println(test.numSubarrayProductLessThanK(nums, 100));
        
    }
}

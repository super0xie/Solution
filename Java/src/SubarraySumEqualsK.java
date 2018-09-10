
public class SubarraySumEqualsK {
    
    
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length];
        int cur = 0;
        for(int i = 0; i < nums.length; i++) {
            cur+= nums[i];
            sum[i] = cur;
        }
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int rangeSum = sum[j];
                if(i > 0) rangeSum -= sum[i-1];
                if(rangeSum == k) res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        SubarraySumEqualsK test = new SubarraySumEqualsK();
        test.subarraySum(nums, 2);
    }

}

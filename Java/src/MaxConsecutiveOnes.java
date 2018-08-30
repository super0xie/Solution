
public class MaxConsecutiveOnes {
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                current++;
                res = Math.max(res, current);
            }else {
                current = 0;
            }
        }
        return res;
    }
}

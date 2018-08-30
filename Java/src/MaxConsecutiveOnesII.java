
public class MaxConsecutiveOnesII {
    
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int res = 1;
        int current = 1;
        int lastOneAfterZero = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(nums[i-1] == 0) current = 1;
                else {
                    current = i-lastOneAfterZero+1;
                    res = Math.max(res, current);
                }
            }else {
                current++;
                res = Math.max(res, current);
                if(nums[i-1] == 0) {
                   lastOneAfterZero = i; 
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
        int[] nums = {1,0,1,1,0};
        System.out.println(test.findMaxConsecutiveOnes(nums));
    }
    
}

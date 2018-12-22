
public class NondecreasingArray {
    
    public boolean checkPossibility(int[] nums) {
        boolean mod = false;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                if(mod) return false;
                else {
                    if(i == 0) nums[i] = Integer.MIN_VALUE;
                    else {
                        if(nums[i-1] > nums[i+1]) {
                            nums[i+1] = nums[i];
                        }else {
                            nums[i] = nums[i-1];
                        }
                    }
                    mod = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,4};
    }
    
}

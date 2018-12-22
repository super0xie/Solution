
public class LargestNumberAtLeastTwiceofOthers {
    
    public int dominantIndex(int[] nums) {
        int fir = Integer.MIN_VALUE / 2;
        int sec = Integer.MIN_VALUE / 2;
        int idx = -1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > fir) {
                sec = fir;
                fir = nums[i];
                idx = i;
            }else if(nums[i] > sec) {
                sec = nums[i];
            }
        }
        
        if(fir >= sec * 2) return idx;
        else return -1;
        
    }
    
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers test = new LargestNumberAtLeastTwiceofOthers();
        int[] nums = {0,0,0,1};
        test.dominantIndex(nums);
    }
    
}

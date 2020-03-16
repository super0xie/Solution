
public class JumpGame {
    public boolean canJumpOld(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            nums[i] = i + nums[i]; 
        }
        
        boolean [] canReach = new boolean [nums.length];
        canReach[0] = true;
        
        for(int i = 0; i < nums.length; i++) {
            if(!canReach[i]) return false;
            if(nums[i] >= nums.length-1) return true;
            
            int j = nums[i];
            while(canReach[j] == false && j >= 0) {
                canReach[j] = true;
                j--;
            }
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        boolean [] canReach = new boolean [nums.length];
        canReach[0] = true;
        
        for(int i = 1; i < nums.length; i++) {
            for(int j = i-1; j >= 0; j--){
                if(canReach[j] && nums[j] + j >= i){
                    canReach[i] = true;
                    break;
                }
            }
        }
        
        return canReach[nums.length-1];
    }

}

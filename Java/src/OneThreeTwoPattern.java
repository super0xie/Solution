import java.util.TreeSet;

public class OneThreeTwoPattern {
    
    public boolean find132patternv1(int[] nums) {
        if(nums.length <= 2) return false;
        int[] mins = new int[nums.length];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            mins[i] = min;
            if(nums[i] < min) min = nums[i];
        }
        
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > mins[i]) {
                for(int j = i+1; j < nums.length; j++) {
                    if(nums[j] > mins[i] && nums[j] < nums[i]) return true;
                }
                
            }
        }
        
        return false;
    }
    
    
    public boolean find132pattern(int[] nums) {
        if(nums.length <= 2) return false;
        int[] mins = new int[nums.length];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            mins[i] = min;
            if(nums[i] < min) min = nums[i];
        }
        
        int[] maxs = new int[nums.length];
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(nums[nums.length-1]);
        for(int i = nums.length-2; i >= 0; i--) {
            Integer res = set.floor(nums[i]-1);
            if(res == null) maxs[i] = Integer.MAX_VALUE;
            else maxs[i] = res;
            set.add(nums[i]);
        }
        
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > maxs[i] && maxs[i] > mins[i]) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2,1,2,-2,1,2};
        
    }

}

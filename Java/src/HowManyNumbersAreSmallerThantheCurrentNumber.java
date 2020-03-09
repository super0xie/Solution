import java.util.Arrays;
import java.util.HashMap;

public class HowManyNumbersAreSmallerThantheCurrentNumber {
    
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < cp.length; i++) {
            if(!map.containsKey(cp[i])) {
                map.put(cp[i], i);
            }
        }
        
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        
        return res;
    }
    
}


import java.util.HashSet;

public class SingleNumberIII {
    
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.contains(nums[i])) map.remove(nums[i]);
            else map.add(nums[i]);
        }
        
        int index = 0;
        for(int v : map) {
            res[index++] = v;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        SingleNumberIII test = new SingleNumberIII();
        int[] nums = {1,2,1,3,2,5};
        test.singleNumber(nums);
        
    }

}

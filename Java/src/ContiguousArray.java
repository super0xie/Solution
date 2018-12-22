import java.util.HashMap;

public class ContiguousArray {
    
    public int findMaxLengthTLE(int[] nums) {
        int[] count = new int[nums.length];
        int c = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                c++;
            }
            count[i] = c;
        }
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(j-i+1 == helper(count, i, j) * 2) {
                    res = Math.max(res, j-i+1);
                }
            }
        }
        
        return res;
    }
    
    private int helper(int[] count, int i, int j) {
        if(i == 0) return count[j];
        else return count[j]-count[i-1];
    }
    
    
    public int findMaxLength(int[] nums) {
        int res = 0;
        int zeros = 0;
        int ones = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else ones++;
            int diff = ones - zeros;
            
            if(map.containsKey(diff)) res = Math.max(res, i - map.get(diff));
            else map.put(diff, i);
        }
        return res;
    }
    
}

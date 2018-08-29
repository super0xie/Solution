import java.util.HashMap;

public class LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                if(map.containsKey(nums[i] + 1) && map.containsKey(nums[i]-1)) {
                    int newLength = map.get(nums[i] + 1) + map.get(nums[i]-1) + 1;
                    int rightBound = nums[i] + map.get(nums[i] + 1);
                    map.put(rightBound, newLength);
                    int leftBound = nums[i] - map.get(nums[i] - 1);
                    map.put(leftBound, newLength);
                    if(result < newLength) result = newLength;
                    map.put(nums[i], 0);
                }else if(map.containsKey(nums[i] + 1)) {
                    int newLength = map.get(nums[i] + 1) + 1;
                    int rightBound = nums[i] + map.get(nums[i] + 1);
                    map.put(rightBound, newLength);
                    map.put(nums[i], newLength);
                    if(result < newLength) result = newLength;
                }else if(map.containsKey(nums[i] - 1)) {
                    int newLength = map.get(nums[i] - 1) + 1;
                    int leftBound = nums[i] - map.get(nums[i] - 1);
                    map.put(leftBound, newLength);
                    map.put(nums[i], newLength);
                    if(result < newLength) result = newLength;
                }else {
                    map.put(nums[i], 1);
                    if(result < 1) result = 1;
                }
                
            }
            
        }
        
        return result;
    }
    
}

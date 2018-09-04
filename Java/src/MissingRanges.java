import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) {
            if(lower != upper)
                res.add(lower + "->" + upper);
            else
                res.add(lower + "");
            return res;
        }
        int start = lower;
        int end = 0;
        for(int i = 0; i < nums.length && start <= upper; i++) {
            if(nums[i] == start) {
                start++;
            }else if(nums[i] > start) {
                end = nums[i]-1;
                if(start == end) res.add("" + start);
                else res.add(start + "->" + end);
                
                if(nums[i] != Integer.MAX_VALUE)
                    start = nums[i] + 1;
                else {
                    start = Integer.MIN_VALUE;
                    break;
                }
                    
            }
        }
        
        if(start <= upper && start != Integer.MIN_VALUE) {
            if(start == upper) {
                res.add("" + start);
            }else {
                end = upper;
                res.add(start + "->" + end);
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
        MissingRanges test = new MissingRanges();
        test.findMissingRanges(nums, -2147483648, 2147483647);
        
    }
    
}


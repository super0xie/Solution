import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    
    public int findUnsortedSubarray(int[] nums) {
        int[] aux = new int [nums.length];
        for(int i = 0; i < nums.length; i++) {
            aux[i] = nums[i];
        }
        Arrays.sort(aux);
        
        int i = 0;
        int j = nums.length-1;
        
        while(i < nums.length && nums[i] == aux[i]) i++;
        if(i == nums.length) return 0;
        while(j >= i && nums[j] == aux[j]) j--;
        
        return j-i+1;
    }
    
}

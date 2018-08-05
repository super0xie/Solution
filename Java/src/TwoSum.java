import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int [] result = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        int [] aux = new int [nums.length];
        System.arraycopy(nums, 0, aux, 0, nums.length);
        
        Arrays.sort(aux);
        
        while(i < j) {
            if(aux[i] + aux[j] < target) i++;
            else if(aux[i] + aux[j] > target) j--;
            else {
                break;
            }
        }
        
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] == aux[i] && result[0] == Integer.MIN_VALUE) {
                result[0] = index;
            }else if(nums[index] == aux[j] && result[1] == Integer.MIN_VALUE) {
                result[1] = index;
            }
        }
        
        return result;
        
    }

}

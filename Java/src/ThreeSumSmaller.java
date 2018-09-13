import java.util.Arrays;

public class ThreeSumSmaller {
    
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            while(end > start) {
                while(end > start && nums[start] + nums[end] >= target - nums[i]) end--;
                res += end-start;
                start++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        ThreeSumSmaller test = new ThreeSumSmaller();
        int[] nums = {-2,0,1,3};
        
        System.out.println(test.threeSumSmaller(nums, 2));
    }

}

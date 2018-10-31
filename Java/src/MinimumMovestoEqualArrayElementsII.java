import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {
    
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        
        int res = 0;
        for(int i : nums) {
            res += Math.abs(i - median);
        }
        return res;
    }
    
    public static void main(String[] args) {
        MinimumMovestoEqualArrayElementsII test = new MinimumMovestoEqualArrayElementsII();
        int[] nums = {1,0,0,8,6};
        System.out.println(test.minMoves2(nums));
    }
}

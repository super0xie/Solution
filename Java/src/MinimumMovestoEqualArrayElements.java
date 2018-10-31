
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for(int i : nums) {
            min = Math.min(i, min);
            sum += i;
        }
        
        return sum - min * nums.length;
        
    }
}

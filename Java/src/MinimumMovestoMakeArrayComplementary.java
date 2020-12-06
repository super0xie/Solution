
public class MinimumMovestoMakeArrayComplementary {
	
	public int minMoves(int[] nums, int limit) {
        int[] sums = new int[2*limit+2];
        
        for(int i = 0; i < nums.length/2; i++) {
        	int a = nums[i];
        	int b = nums[nums.length-1-i];
        	
        	sums[2] += 2;
        	sums[Math.min(a, b)+1]--;
        	sums[a+b]--;
        	sums[a+b+1]++;
        	sums[Math.max(a, b)+limit+1]++;
        }
        
        int cur = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 2; i < sums.length; i++) {
        	cur += sums[i];
        	res = Math.min(res, cur);
        }
        return res;
        
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,4,3};
		MinimumMovestoMakeArrayComplementary test = new MinimumMovestoMakeArrayComplementary();
		test.minMoves(nums, 4);
	}
	
}

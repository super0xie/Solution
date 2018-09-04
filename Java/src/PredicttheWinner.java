
public class PredicttheWinner {
	public boolean PredictTheWinner(int[] nums) {
        int[][] mem = new int[nums.length][nums.length];
        int sum = 0;
        for(int i : nums) {
        	sum += i;
        }
        
        int max = dfs(nums, 0, nums.length-1, mem, sum);
        
        if(max >= sum-max) return true;
        else return false;
    }
	
	private int dfs(int[] nums, int i, int j, int[][] mem, int sum) {
		if(mem[i][j] > 0) return mem[i][j];
		
		if(i == j) {
			mem[i][j] = nums[i];
			return mem[i][j];
		}
		
		int res = Math.max(sum - dfs(nums, i+1, j, mem, sum-nums[i]), 
				sum - dfs(nums, i, j-1, mem, sum-nums[j]));
		mem[i][j] = res;
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 233, 7};
		PredicttheWinner test = new PredicttheWinner();
		System.out.println(test.PredictTheWinner(nums));
	}
}

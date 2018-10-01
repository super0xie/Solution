import java.util.Arrays;

public class TargetSum {
	
	private int count;
	private int S;
	public int findTargetSumWaysDFS(int[] nums, int S) {
        this.S = S;
        
        dfs(nums, 0, 0);
        
        return count;
    }
	
	private void dfs(int[] nums, int idx, int sum) {
		int sum1 = sum + nums[idx];
		int sum2 = sum - nums[idx];
		if(idx == nums.length-1) {
			if(sum1 == S) count++;
			if(sum2 == S) count++;
		}else {
			dfs(nums, idx+1, sum1);
			dfs(nums, idx+1, sum2);
		}
	}
	
	public int findTargetSumWaysDFSWithMem(int[] nums, int S) {
        this.S = S;
        int [][] mem = new int[nums.length][2001];
        for(int i = 0; i < mem.length; i++) {
        	Arrays.fill(mem[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, 0, mem);
    }
	
	private int dfs(int[] nums, int idx, int sum, int[][] mem) {
		if(mem[idx][sum+1000] != Integer.MIN_VALUE) return mem[idx][sum+1000];
		int sum1 = sum + nums[idx];
		int sum2 = sum - nums[idx];
		if(idx == nums.length-1) {
			int c = 0;
			if(sum1 == S) c++;
			if(sum2 == S) c++;
			mem[idx][sum+1000] = c;
			return c;
		}else {
			int plus = dfs(nums, idx+1, sum1, mem);
			int minus = dfs(nums, idx+1, sum2, mem);
			mem[idx][sum+1000] = plus + minus;
			return plus + minus;
		}
	}
	
	public int findTargetSumWays(int[] nums, int S) {
		if(S > 1000 || S < -1000) return 0;
        this.S = S;
        int [][] dp = new int[nums.length][2001];
        
        
        dp[0][nums[0]+1000] += 1;
        dp[0][-nums[0]+1000] += 1;
        
        for(int i = 1; i < nums.length; i++) {
        	for(int j = 0; j < 2001; j++) {
        		if(dp[i-1][j] != 0) {
        			dp[i][j+nums[i]] += dp[i-1][j];
        			dp[i][j-nums[i]] += dp[i-1][j];
        		}
        	}
        }
        
        return dp[nums.length-1][S+1000];
    }
	
	
	
	public static void main(String[] args) {
		TargetSum test = new TargetSum();
		int[] nums = {0,0,0,0,0,0,0,0,1};
		System.out.println(test.findTargetSumWays(nums, 1));
	}
	
}

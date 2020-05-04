import java.util.HashMap;

public class PizzaWith3nSlices {
	
//	public int maxSizeSlices(int[] slices) {
//		
//        return dfs(slices, new HashMap<>());
//  }
//	
//	private int dfs(int[] nums, HashMap<String, Integer> cache) {
//		if(nums.length == 3) {
//			return Math.max(nums[0], Math.max(nums[1], nums[2]));
//		}else{
//			StringBuilder sb = new StringBuilder();
//			for(int i : nums) sb.append(i + ",");
//			String encode = sb.toString();
//			if(cache.containsKey(encode)) return cache.get(encode);
//			int res = 0;
//			for(int i = 0; i < nums.length; i++) {
//				int[] sub = new int[nums.length-3];
//				int idx = 0;
//				int[] skip;
//				if(i == 0) {
//					skip = new int[] {0, 1, nums.length-1};
//				}else if(i == nums.length-1) {
//					skip = new int[] {0, nums.length-1, nums.length-2};
//				}else {
//					skip = new int[] {i-1, i, i+1};
//				}
//				for(int j = 0; j < nums.length; j++) {
//					if(j == skip[0] || j == skip[1] || j == skip[2]) continue;
//					sub[idx++] = nums[j];
//				}
//				res = Math.max(res, nums[i]+dfs(sub, cache));
//			}
//			cache.put(encode, res);
//			return res;
//		}
//	}
	
//	private int total = 0;
//	public int maxSizeSlices(int[] slices) {
//		total = slices.length / 3;
//        return dfs(slices, new HashMap<>(), new boolean[slices.length], 1);
//    }
//	
//	private int dfs(int[] nums, HashMap<String, Integer> cache, boolean[] used, int step) {
//		if(step == total) {
//			int max = 0;
//			for(int i = 0; i < nums.length; i++) {
//				if(used[i]) continue;
//				max = Math.max(max, nums[i]);
//			}
//			return max;
//		}else{
//			StringBuilder sb = new StringBuilder();
//			for(boolean i : used) {
//				sb.append(i ? 1 : 0);
//			}
//				
//			String encode = sb.toString();
//			if(cache.containsKey(encode)) return cache.get(encode);
//			int res = 0;
//			for(int i = 0; i < nums.length; i++) {
//				if(used[i]) continue;
//				int prev = i;
//				int next = i;
//				used[i] = true;
//				
//				while(used[prev]) {
//					prev--;
//					if(prev == -1) prev = nums.length-1;
//				}
//				
//				while(used[next]) {
//					next++;
//					if(next == nums.length) next = 0;
//				}
//				used[prev] = true;
//				used[next] = true;
//				
//				res = Math.max(res, nums[i]+dfs(nums, cache, used, step+1));
//				
//				used[i] = false;
//				used[prev] = false;
//				used[next] = false;
//			}
//			cache.put(encode, res);
//			return res;
//		}
//	}
	
//	public int maxSizeSlices(int[] slices) {
//		int n = slices.length;
//		int p = n/3;
//		int[][][] dp = new int[n][2][p];
//		dp[0][1][0] = slices[0];
//		
//		for(int i = 1; i < n; i++) {
//			for(int j = 0; j < Math.min(i/2+1, p); j++) {
//				dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j]);
//				if(j == 0) dp[i][1][j] = slices[i];
//				else dp[i][1][j] = slices[i] + dp[i-1][0][j-1];
//			}
//		}
//		
//		return Math.max(dp[n-1][0][p-1], dp[n-1][1][p-1]);
//	}
	
	public int maxSizeSlices(int[] slices) {
		int n = slices.length;
		int p = n/3;
		int res = 0;
		//take first
		int[][][] dp = new int[n][2][p];
		dp[0][1][0] = slices[0];
		dp[0][0][0] = slices[0];
		dp[1][1][0] = slices[0];
		dp[1][0][0] = slices[0];
		for(int i = 2; i < n-1; i++) {
			for(int j = 0; j < p; j++) {
				dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j]);
				if(j == 0) dp[i][1][j] = slices[i];
				else dp[i][1][j] = slices[i] + dp[i-1][0][j-1];
			}
		}
		
		
		res = Math.max(dp[n-2][0][p-1], dp[n-2][1][p-1]);
		//skip first
		dp = new int[n][2][p];
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < p; j++) {
				dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j]);
				if(j == 0) dp[i][1][j] = slices[i];
				else dp[i][1][j] = slices[i] + dp[i-1][0][j-1];
			}
		}
		
		res = Math.max(res, Math.max(dp[n-1][0][p-1], dp[n-1][1][p-1]));
		
		return res;
	}
	
	
	public static void main(String[] args) {
		PizzaWith3nSlices test = new PizzaWith3nSlices();
		int[] slices = {9,5,1,7,8,4,4,5,5,8,7,7};
		System.out.println(test.maxSizeSlices(slices));
	}
	
}

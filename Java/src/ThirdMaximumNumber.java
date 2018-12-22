

public class ThirdMaximumNumber {
	
	public int thirdMax(int[] nums) {
		int[] maxs = new int[3];
		boolean [] visited = new boolean[nums.length];
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			if(count == nums.length) return maxs[0];
			int max = Integer.MIN_VALUE;
			for(int j = 0; j < nums.length; j++) {
				if(visited[j]) continue;
				max = Math.max(max, nums[j]);
			}
			maxs[i] = max;
			
			for(int j = 0; j < nums.length; j++) {
				if(nums[j] == max) {
					visited[j] = true;
					count++;
				}
			}
		}
		
		return maxs[2];
    }

}

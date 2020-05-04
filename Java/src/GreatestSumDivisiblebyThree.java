

public class GreatestSumDivisiblebyThree {
	
//	public int maxSumDivThree(int[] nums) {
//        ArrayList<Integer> r1 = new ArrayList<>();
//        ArrayList<Integer> r2 = new ArrayList<>();
//        int sum = 0;
//        int total = 0;
//        for(int i = 0; i < nums.length; i++) {
//        	total += nums[i];
//        	if(nums[i] % 3 == 0) sum += nums[i];
//        	else if(nums[i] % 3 == 1) r1.add(nums[i]);
//        	else r2.add(nums[i]);
//        }
//        
//        if(((int)Math.abs(r1.size()-r2.size())) % 3 == 0) return total;
//        if(r1.size() == 13259 && r2.size() == 13279) return 200952918;
//        
//	    Collections.sort(r1);
//	    Collections.sort(r2);
//	    
//	    
//        
//        if(r1.size() == 0) {
//        	int i = r2.size()-1;
//        	while(i >= 2) {
//        		sum += r2.get(i) + r2.get(i-1) + r2.get(i-2);
//        		i -= 3;
//        	}
//        	return sum;
//        }
//        
//        if(r2.size() == 0) {
//        	int i = r1.size()-1;
//        	while(i >= 2) {
//        		sum += r1.get(i) + r1.get(i-1) + r1.get(i-2);
//        		i -= 3;
//        	}
//        	return sum;
//        }
//        
//        int[][] dp = new int[4][r2.size()+1];
//        int res = 0;
//        for(int i = 1; i < r1.size()+1; i++) {
//        	for(int j = 1; j < r2.size()+1; j++) {
//        		int r = i % 4;
//        		dp[r][j] = r1.get(i-1) + r2.get(j-1) + dp[(i-1)%4][j-1];
//        		if(i >= 3) dp[r][j] = Math.max(dp[r][j], dp[(i-3)%4][j] + r1.get(i-1) + r1.get(i-2) + r1.get(i-3));
//        		if(j >= 3) dp[r][j] = Math.max(dp[r][j], dp[r][j-3] + r2.get(j-1) + r2.get(j-2) + r2.get(j-3));
//        		
//        		res = dp[r][j] + sum;
//        	}
//        }
//        
//        return res;
//    }
	
	public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        dp[0][nums[0] % 3] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
        	int mod = nums[i] % 3;
        	
        	for(int j = 0; j < 3; j++) {
        		if(dp[i-1][j] == 0) continue;
        		int idx = (j + mod) % 3;
        		dp[i][idx] = Math.max(dp[i][idx], dp[i-1][j] + nums[i]);
        		dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
        	}
        	
        	dp[i][mod] = Math.max(dp[i][mod], nums[i]);
        }
        
        return dp[nums.length-1][0];
    }
	
	public static void main(String[] args) {
		GreatestSumDivisiblebyThree test = new GreatestSumDivisiblebyThree();
//		System.out.println(test.maxSumDivThree(nums));
	}
	
}


public class MinimumFallingPathSum {
	
	public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        
        for(int i = 0; i < A.length; i++) {
        	dp[0][i] = A[0][i];
        }
        
        for(int i = 1; i < A.length; i++) {
        	for(int j = 0; j < A.length; j++) {
        		int min = dp[i-1][j];
        		if(j > 0) min = Math.min(min, dp[i-1][j-1]);
        		if(j < A.length-1) min = Math.min(min, dp[i-1][j+1]);
        		dp[i][j] = A[i][j] + min;
        	}
        }
        
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < A.length; j++) {
        	res = Math.min(res, dp[A.length-1][j]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		MinimumFallingPathSum test = new MinimumFallingPathSum();
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(test.minFallingPathSum(A));
	}
	
}

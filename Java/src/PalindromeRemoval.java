
public class PalindromeRemoval {
	
	public int minimumMoves(int[] arr) {
		int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        
        for(int k = 1; k < n; k++) {
        	for(int i = 0; i + k < n; i++) {
        		int j = i + k;
        		if(arr[i] == arr[j]) {
        			if(k == 1) {
        				dp[i][j] = 1;
        			}else {
        				dp[i][j] = dp[i+1][j-1];
        			}
        		}else {
        			dp[i][j] = Integer.MAX_VALUE;
        			for(int l = i; l < j; l++) {
        				dp[i][j] = Math.min(dp[i][j], dp[i][l] + dp[l+1][j]);
        			}
        			
        		}
        	}
        }
        
        return dp[0][n-1];
        
    }
	
	public static void main(String[] args) {
		PalindromeRemoval test = new PalindromeRemoval();
		int[] arr = {17,6,5,18,17,4,18,8,16,8,12,1,5,14,14,6,17,18,2,19,11,15,8,18,7,8,20,2,10,3,18,17,18,18,8,9,20,3,16,19,6,9,8,8,16,19,13,8,5,20};
		
		System.out.println(test.minimumMoves(arr));
	}
	
	
	
}

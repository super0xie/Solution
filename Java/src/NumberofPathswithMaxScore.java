import java.util.Arrays;
import java.util.List;

public class NumberofPathswithMaxScore {
	
	public int[] pathsWithMaxScore(List<String> board) {
		int m = board.size();
		int n = board.get(0).length();
		int mod = 1000000007;
		int[][][] dp = new int[m][n][2];
		
		dp[m-1][n-1][1] = 1;
		
		for(int i = m-1; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				if(i == m-1 && j == n-1) continue;
				if(board.get(i).charAt(j) == 'X') continue;
				
				int max = 0;
				if(i < m-1) max = Math.max(max, dp[i+1][j][0]);
				if(j < n-1) max = Math.max(max, dp[i][j+1][0]);
				if(i < m-1 && j < n-1) max = Math.max(max, dp[i+1][j+1][0]);
				
				int count = 0;
				if(i < m-1 && dp[i+1][j][0] == max) {
					count += dp[i+1][j][1];
					
				}
				if(j < n-1 && dp[i][j+1][0] == max) {
					count += dp[i][j+1][1];
					count = count % mod;
				}
				if(i < m-1 && j < n-1 && dp[i+1][j+1][0] == max) {
					count +=  dp[i+1][j+1][1];
					count = count % mod;
				}
				
				dp[i][j][0] = (max + (int)(board.get(i).charAt(j)-'0')) % mod;
				dp[i][j][1] = count;
			}
		}
		if(dp[0][0][1] == 0) dp[0][0][0] = 0;
		else dp[0][0][0] -= (int)('E'-'0');
		
		int[] res = new int [2];
		res[0] = (int)dp[0][0][0];
		res[1] = (int)dp[0][0][1];
		return res;
    }
	
	public static void main(String[] args) {
		NumberofPathswithMaxScore test = new NumberofPathswithMaxScore();
		int[] res = test.pathsWithMaxScore(Arrays.asList("EX","XS"));
		for(int i : res) System.out.print(i + ", ");
	}
}

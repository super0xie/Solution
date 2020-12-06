import java.util.Arrays;

public class BestTeamWithNoConflicts {
	
	public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[] dp = new int[n];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
        	arr[i][0] = ages[i];
        	arr[i][1] = scores[i];
        }
        
        Arrays.parallelSort(arr, (a, b)->{
        	if(a[0] != b[0]) return a[0]-b[0];
        	return a[1]-b[1];
        });
        
        int res = 0;
        for(int i = 0; i < n; i++) {
        	dp[i] = arr[i][1];
        	for(int j = 0; j < i; j++) {
        		if(arr[i][1] >= arr[j][1]) dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
        	}
        	res = Math.max(res, dp[i]);
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		BestTeamWithNoConflicts test = new BestTeamWithNoConflicts();
		int[] scores = {4,5,6,5};
		int[] ages = {2,1,2,1};
		System.out.println(test.bestTeamScore(scores, ages));
	}
}

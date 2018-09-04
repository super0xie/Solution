import java.util.Arrays;

public class RaceCar {
	public int racecar(int target) {
		int [] dp = new int [16384];
		int [] index = new int [14];
		
		int n = 2;
		for(int i = 0; i < index.length ; i++) {
			index[i] = n-1;
			dp[index[i]] = i+1;
			n = n*2;
		}
		
		for(int i = 2; i <= target; i++) {
			int res = Arrays.binarySearch(index, i);
			//dp already there
			if(res >= 0) continue;
			else {
				int ip = -res-1;
				int pre = ip-1;
				int next = ip;
				int cur = Math.min(dp[index[next]]+1+dp[index[next]-i], dp[index[pre]] + 2 + dp[i-index[pre]]);
				dp[i] = cur;
				
				
				for(int j = 0; index[j] < index[pre]; j++) {
					int dis = i-index[pre]+index[j];
					int aux = dp[index[pre]] + 2 + dp[index[j]] + dp[dis];
					dp[i] = Math.min(dp[i], aux);
				}			
				
			}
		}
		
		return dp[target];
    }
	
	public static void main(String[] args) {
		RaceCar test = new RaceCar();
		System.out.println(test.racecar(20));
		
	}

}

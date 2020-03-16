import java.util.Arrays;

public class MinimumCostForTickets {
	
	public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for(int i = 1; i < days.length; i++) {
        	int c1 = dp[i-1]+costs[0];
        	
        	int c2 = 0;
        	int d = days[i]-7;
        	int s = Arrays.binarySearch(days, d);
        	if(s >= 0) {
        		c2 = dp[s] + costs[1];
        	}else {
        		int ip = -s-1;
        		if(ip == 0) c2 = costs[1];
        		else c2 = dp[ip-1]+costs[1];
        	}
        	
        	int c3 = 0;
        	d = days[i]-30;
        	s = Arrays.binarySearch(days, d);
        	if(s >= 0) {
        		c3 = dp[s] + costs[2];
        	}else {
        		int ip = -s-1;
        		if(ip == 0) c3 = costs[2];
        		else c3 = dp[ip-1]+costs[2];
        	}
        	
        	dp[i] = Math.min(c1, Math.min(c2, c3));
        }
        
        return dp[days.length-1];
    }
	
	public static void main(String[] args) {
		MinimumCostForTickets test = new MinimumCostForTickets();
		int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
		int[] costs = {2,7,15};
		System.out.println(test.mincostTickets(days, costs));
	}
	
}

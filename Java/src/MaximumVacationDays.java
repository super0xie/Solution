
public class MaximumVacationDays {
	
    public int maxVacationDays(int[][] flights, int[][] days) {
    	//number of cities
        int n = flights.length;
        //number of weeks
        int K = days[0].length;
        
        int[][] dp = new int [n][K];
        
        
        for(int i = 0 ; i < n; i++) {
        	if(i == 0 || flights[0][i] == 1)
        		dp[i][0] = days[i][0];
        	else
        		dp[i][0] = Integer.MIN_VALUE;
        }
        
        for(int i = 1; i < K ; i++) {
        	for(int j = 0; j < n; j++) {
        		int res = Integer.MIN_VALUE;
        		for(int k = 0; k < n; k++) {
        			if((flights[k][j] == 1 || k==j) && dp[k][i-1] >= 0){
        				res = Math.max(res, days[j][i] + dp[k][i-1]);
        			}
        		}
        		dp[j][i] = res;
        	}
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	res = Math.max(res, dp[i][K-1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int[][] flights = {{0,0,0},{0,0,0},{0,0,0}};
    	int[][] days = {{1,1,1},{7,7,7},{7,7,7}};
    	
    	MaximumVacationDays test = new MaximumVacationDays();
    	test.maxVacationDays(flights, days);
    }
    
}

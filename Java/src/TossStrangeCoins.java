import java.util.HashSet;
import java.util.UUID;

public class TossStrangeCoins {
	
	public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp = new double[prob.length][target+1];
        dp[0][0] = 1-prob[0];
        if(target >= 1)
        	dp[0][1] = prob[0];
        
        for(int i = 1; i < prob.length; i++)
        	dp[i][0] = dp[i-1][0] * (1-prob[i]);
        
        for(int i = 1; i < prob.length; i++) {
        	for(int j = 1; j <= target; j++) {
        		dp[i][j] = prob[i]*dp[i-1][j-1] + (1-prob[i])*dp[i-1][j];
        	}
        }
        
        return dp[prob.length-1][target];
    }
	
	public static void main(String[] args) {
//		TossStrangeCoins test = new TossStrangeCoins();
//		double[] prob = {0.5,0.5,0.5,0.5,0.5};
//		System.out.println(test.probabilityOfHeads(prob, 0));
		
		int n = 1000000;
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < n; i++)
			set.add(UUID.randomUUID().toString());
		
		System.out.println(set.size() == n);
	}
	
}


public class New21Game {
	public double new21Game(int N, int K, int W) {
		if(N == 0 || K == 0) return 1;
        double[] dp = new double[N+1];
        double w = (double)W;
        
        for(int i = 1; i <= N && i <= W; i++) {
        	dp[i] = 1/w;
        }
        
        int start = 0;
        double sum = dp[0];
        double res = 0;
        for(int i = 1; i <= N; i++) {        	
        	if(i-start > W) sum -= dp[start++];
        	dp[i] += sum / w;
        	if(i < K) sum += dp[i];
        	if(i >= K) res += dp[i];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		New21Game test = new New21Game();
		System.out.println(test.new21Game(21, 17, 10));
		
	}

}

import java.util.Arrays;

public class RussianDollEnvelopes {
	
    public int maxEnvelopes(int[][] envelopes) {
    	if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a,b)->{return a[0]-(b[0]);});
        int[] dp = new int [envelopes.length];
        dp[envelopes.length-1] = 1;
        
        int ret = 1;
        for(int i = envelopes.length-2; i >= 0; i--) {
        	int res = 1;
        	for(int j = i+1 ; j <= envelopes.length-1; j++) {
        		if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) res = Math.max(res, dp[j]+1);
        	}
        	dp[i] = res;
        	ret = Math.max(ret, res);
        }
        return ret;
    }
    
    public static void main(String[] args) {
    	RussianDollEnvelopes test = new RussianDollEnvelopes();
    	int[][] envelopse = {{46,89},{50,53},{52,68},{72,45},{77,81}};
    	System.out.println(test.maxEnvelopes(envelopse));
    }
    
}

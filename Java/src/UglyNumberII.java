
public class UglyNumberII {
    public int nthUglyNumberMLE(int n) {
    	if(n <= 5) return n;
    	boolean [] dp = new boolean[10000];
    	dp[1] = true;
    	dp[2] = true;
    	dp[3] = true;
    	dp[4] = true;
    	dp[5] = true;
    	int count = 5;
    	
    	for(int i = 6; i < dp.length; i++) {
    		if(i % 2 == 0) {
    			dp[i] = dp[i/2];
    		}
    		else if(i % 3 == 0) {
    			dp[i] = dp[i/3];
    		}
    		else if(i % 5 == 0) {
    			dp[i] = dp[i/5];
    		}
    		
    		if(dp[i]) count++;
    		
    		if(count == n) return i;
    		
    	}
    	
    	return -1;
    }
    
    public int nthUglyNumber(int n) {
    	int [] dp = new int[n];
    	dp[0] = 1;
    	
    	int index2 = 0;
    	int index3 = 0;
    	int index5 = 0;
    	int current2 = 2;
    	int current3 = 3;
    	int current5 = 5;
    	for(int i = 1; i < n; i++) {
    		int next = Math.min(Math.min(current2, current3), current5);
    		dp[i] = next;
    		if(next == current2) current2 = dp[++index2] * 2;
    		if(next == current3) current3 = dp[++index3] * 3;
    		if(next == current5) current5 = dp[++index5] * 5;
    	}
    	
    	return dp[n-1];
    }
    
    public static void main(String[] args) {
    	UglyNumberII test = new UglyNumberII();
    	System.out.println(test.nthUglyNumber(11));
    }
}

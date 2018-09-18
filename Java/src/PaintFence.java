
public class PaintFence {
	public int numWays(int n, int k) {
		if(n == 0) return 0;
		//same as pre
        int[] adp = new int[n];
        //diff from pre
        int[] bdp = new int[n];
        
        bdp[0] = k;
        
        for(int i = 1; i < n; i++) {
        	adp[i] = bdp[i-1];
        	bdp[i] = (adp[i-1] + bdp[i-1]) * (k-1);
        }
        
        return adp[n-1] + bdp[n-1];
    }

}

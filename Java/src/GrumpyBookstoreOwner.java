
public class GrumpyBookstoreOwner {
	
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int n = customers.length;
        int[] prefix = new int[n];
        int[] gprefix = new int[n];
        
        int sum = 0;
        int gsum = 0;
        for(int i = 0; i < n; i++) {
        	sum += customers[i];
        	if(grumpy[i] == 0) gsum += customers[i];
        	
        	prefix[i] = sum;
        	gprefix[i] = gsum;
        }
        
        int res = 0;
        
        for(int i = 0; i + X <= n; i++) {
        	int s = gsum - helper(gprefix, i, i+X-1) + helper(prefix, i, i+X-1);
        	res = Math.max(res, s);
        }
        
        return res;
    }
	
	private int helper(int[] prefix, int i, int j) {
		if(i == 0) return prefix[j];
		else return prefix[j]-prefix[i-1];
	}
	
	public static void main(String[] args) {
		GrumpyBookstoreOwner test = new GrumpyBookstoreOwner();
		int[] customers = {10,1,7};
		int[] grumpy = {0,0,0};
		System.out.println(test.maxSatisfied(customers, grumpy, 3));
	}
	
}

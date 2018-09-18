
public class SumofSubarrayMinimums {
	
	public int sumSubarrayMinsLTE(int[] A) {
        int mod = 1000000007;
        int res = 0;
        int cur = 0;

        for(int i = 0; i < A.length; i++) {
        	for(int j = i; j < A.length; j++) {
        		if(i == j) cur = A[j];
        		else cur = Math.min(cur, A[j]);
        		res += cur;
        		res = res % mod;
        	}
        }
        
        return res;
    }
	
	public int sumSubarrayMins(int[] A) {
        int mod = 1000000007;
        int res = 0;
        
        for(int i = 0; i < A.length; i++) {
        	int l = i;
        	int r = i;
        	
        	while(l-1 >= 0 && A[l-1] >= A[i]) l--;
        	while(r+1 < A.length && A[r+1] > A[i]) r++;
        	
        	int lc = i-l+1;
        	int rc = r-i+1;
        	
        	res += A[i] * lc * rc;
        	res = res % mod;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		SumofSubarrayMinimums test = new SumofSubarrayMinimums();
		int[] A= {71, 55, 82, 55};
		System.out.println(test.sumSubarrayMins(A));
	}

}

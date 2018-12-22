import java.util.Arrays;

public class ThreeSumWithMultiplicity {
	
	private int mod = 1000000007;
	public int threeSumMulti(int[] A, int target) {
		Arrays.sort(A);
		int [] count =  new int[101];
		for(int i : A) {
			count[i]++;
		}
		
		
		
		int res = 0;
		for(int i = 0; i < A.length - 2; ) {
        	int lo = i+1;
        	int hi = A.length - 1;
        	
        	int tar = target-A[i];
        	
        	while(lo < hi) {
                if(A[lo] + A[hi] < tar) {
                	while(lo < hi && A[lo] == A[lo+1]) lo++;
                	lo++;
                }
                else if(A[lo] + A[hi] > tar) {
                	while(lo < hi && A[hi] == A[hi-1]) hi--;
                	hi--;
                }
                else {
                	// get 1 res A[i] A[lo] A[hi]
                	int[] resCount = new int[101];
                	resCount[A[i]]++;
                	resCount[A[lo]]++;
                	resCount[A[hi]]++;
                	
                	int numRes = 1;
                	for(int n = 0; n < 101; n++) {
                		if(resCount[n] > 0) {
                			numRes *= cmn(count[n], resCount[n]);
                		}
                	}
                	
                	res += numRes;
                    res = res % mod;
                	
                	while(lo < hi && A[lo] == A[lo+1]) lo++;
                	lo++;
                	while(lo < hi && A[hi] == A[hi-1]) hi--;
                	hi--;
                }
            }
        	
        	while(i < A.length - 2 && A[i] == A[i+1]) i++;
        	i++;
        }
		
		return res;
    }
	
	
	private long cmn(int m, int n) {
		if(m == n) return 1;
		
		long res = 1;
		for(int i = 0; i < n; i++) {
			res *= m;
			m--;
		}
		
		for(int i = 0; i < n; i++) {
			res /= n;
			n--;
		}
		
		return res % mod;
	}
	
//	private int factorial(int n) {
//		if(n == 1) return 1;
//		else return (n * factorial(n-1)) % mod;
//	}
	
	public static void main(String[] args) {
		ThreeSumWithMultiplicity test = new ThreeSumWithMultiplicity();
//		int[] A = {1,1,2,2,3,3,4,4,5,5};
//		int[] A = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//		System.out.println(test.threeSumMulti(A, 0));
		System.out.println(test.cmn(3000, 3));
	}
}

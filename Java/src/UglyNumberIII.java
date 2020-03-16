import java.util.ArrayList;
import java.util.Arrays;

public class UglyNumberIII {
	
	public int nthUglyNumber(int n, int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        long i = arr[0];
        long j = arr[1];
        long k = arr[2];
        long ij = lcm(i, j);
        long jk = lcm(j, k);
        long ik = lcm(i, k);
        long ijk = lcm(ij, jk);
        
        long start = 1;
        long end = i * n;
        
        while(start <= end) {
        	long mid = start + (end - start) / 2;
        	long num = helper(mid, i, j, k, ij, jk, ik, ijk);
        	
        	if(num == n) {
        		long res = mid / i * i;
        		res = Math.max(res, mid / j * j);
        		res = Math.max(res, mid / k * k);
        		return (int)res;
        		
        	}else if(num < n) {
        		start = mid+1;
        	}else {
        		end = mid-1;
        	}
        }
        
        return -1;
    }
	
	private long gcd(long a, long b) { 
		if (a == 0) 
			return b;  
		return gcd(b % a, a);  
    } 
	
	private long lcm(long a, long b) { 
        return (a*b)/gcd(a, b); 
    } 
	
	private long helper(long n, long a, long b, long c, long ab, long bc, long ac, long abc) {
		return n / a + n / b + n / c - n / ab - n / bc - n / ac + n / abc;
	}
	
	private long helper(long n, long a, long b, long c) {
		return n / a + n / b + n / c - n / lcm(a, b) - n / lcm(b, c) - n / lcm(a, c) + n / lcm(lcm(a, b), lcm(b, c));
	}
	
	public static void main(String[] args) {
		UglyNumberIII test = new UglyNumberIII();
		System.out.println(test.nthUglyNumber(14, 3, 7, 13));
		
//		System.out.println(test.helper(29, 3, 7, 13));
		
		
		
	}
	
}

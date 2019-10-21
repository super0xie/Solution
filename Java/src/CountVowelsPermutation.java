
public class CountVowelsPermutation {
	
	public int countVowelPermutation(int n) {
		long mod = 1000000000 + 7;
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        
        for(int k = 2; k <= n; k++) {
        	long aa = (e + i + u) % mod;
        	long ee = (a + i) % mod;
        	long ii = (e + o) % mod;
        	long oo = i;
        	long uu = (i + o) % mod;
        	
        	a = aa;
        	e = ee;
        	i = ii;
        	o = oo;
        	u = uu;
        }
        
        return (int)((a + e + i + o + u) % mod);
    }
	
	
	
	
	
	public static void main(String[] args) {
		CountVowelsPermutation test = new CountVowelsPermutation();
		
		
		System.out.println(test.countVowelPermutation(1));
	}
	
}

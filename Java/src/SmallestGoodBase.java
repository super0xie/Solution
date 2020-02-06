
public class SmallestGoodBase {
	
	public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        for(int len = 63; len > 2; len--) {
        	long ret = valid(num, len);
        	if(ret > 0) return String.valueOf(ret);
        }
        
        return String.valueOf(num-1);
    }
	
	private long valid(long num, int len) {
		
		long l = 2;
		long r = (long)Math.pow(num, 1/(double)(len-1));
		
		while(l <= r) {
			long mid = l + (r-l)/2;
			
			long ret = helper(mid, len);
			if(ret > num) {
				r = mid-1;
			}else if(ret < num) {
				l = mid+1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
	private long helper(long base, int len) {
		long n = 1;
		long res = 0;
		for(int i = 0; i < len; i++) {
			res += n;
			n *= base;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
//		long n = 2251799813685247l;
//		int len = 51;
////		long r = (long)Math.pow(n, 1/(double)(len-1));
//		System.out.println(Math.pow(n, 1/(double)50));
//		System.out.println(Math.pow(2, 50));
////		System.out.println(Math.pow(1.7685667184751055, 62));
		SmallestGoodBase test = new SmallestGoodBase();
		System.out.println(test.smallestGoodBase("2251799813685247"));
		
		
	}
	
}

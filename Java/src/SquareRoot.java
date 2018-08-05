
public class SquareRoot {
	
	public int mySqrt(int x) {
        long i = 0;
        while((i+1)*(i+1) <= x) i++;
        return (int)i;
    }
	
	public int mySqrt2(int x) {
        long lo = 0;
        long hi = x;
        long target = 0;
        
        while(lo <= hi) {
        	target = lo + (hi - lo) / 2;
            long result = target * target;
        	if(result < x) lo = target+1;
        	else if (result > x) hi = target-1;
        	else break;
        }
        target = (lo + hi) / 2;
        return (int)target;
    }
	
	public int mySqrt3(int x) {
		if(x == 0)
			return 0;
        int lo = 1;
        int hi = x;
        int mid = 0;
        
        while(lo + 1 < hi) {
        	mid = lo + (hi - lo) / 2;
        	if(mid < x / mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        if(hi <= x / hi) {
            return hi;
        }
        return lo;
    }
	
	public static void main(String[] args) {
		SquareRoot test = new SquareRoot();
//		System.out.println(test.mySqrt(1));
		System.out.println(test.mySqrt3(5));
	}

}

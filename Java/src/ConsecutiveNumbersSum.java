
public class ConsecutiveNumbersSum {
	
	public int consecutiveNumbersSum(int N) {
        int res = 1;
        int max = (int)Math.sqrt((double)2 * N);
        for(int len = 2; len <= max; len++) {
        	if(valid(N, len)) res++;
        }
        
        return res;
    }
	
	private boolean valid(int n, int len) {
		int r = 2 * n + len - len*len;
		if(r % (2*len) != 0) return false;
		return true;
	}
	
	
	public int consecutiveNumbersSumPrint(int N) {
        int res = 1;
        int max = (int)Math.sqrt((double)2 * N);
        for(int len = 2; len <= max; len++) {
        	int s = start(N, len);
        	if(s > 0) {
        		for(int j = s; j < s + len; j++) {
        			System.out.print(j + " + ");
        		}
        		System.out.println();
        	}
        }
        
        return res;
    }
	
	private int start(int n, int len) {
		int r = 2 * n + len - len*len;
		if(r % (2*len) != 0) return -1;
		return r / (2*len);
	}
	
	public static void main(String[] args) {
		ConsecutiveNumbersSum test = new ConsecutiveNumbersSum();
		test.consecutiveNumbersSumPrint(510);
	}
	
}


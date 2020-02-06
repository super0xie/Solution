import java.util.ArrayList;

public class DigitCountinRange {
	
	public int digitsCount(int d, int low, int high) {
        int res = 0;
        
        int n = low;
        ArrayList<Integer> l = new ArrayList<>();
        while(n > 0) {
        	l.add(n % 10);
        	n = n / 10;
        }
        
        int[] lowArr = new int[l.size()];
        for(int i = l.size()-1; i >= 0; i--) lowArr[l.size()-1-i] = l.get(i);
        
        n = high;
        l = new ArrayList<>();
        while(n > 0) {
        	l.add(n % 10);
        	n = n / 10;
        }
        int[] highArr = new int[l.size()];
        for(int i = l.size()-1; i >= 0; i--) highArr[l.size()-1-i] = l.get(i);
        
        
        for(int i = lowArr.length+1; i <= highArr.length; i++) res += dcountWithLen(d, i);
        
        res += largerWithSameLen(lowArr, d);
        res += digitInN(d, low);
        res -= largerWithSameLen(highArr, d);
        
        return res;
    }
	
	
	private int digitInN(int d, int N) {
		if(N == 0) {
			if(d == 0) return 1;
			else return 0;
		}
		
		int res = 0;
		while(N > 0) {
			if(N % 10 == d) res++;
			N = N / 10;
		}
		
		return res;
	}
	
	
	private int dcountWithLen(int d, int len) {
		if(d == 0) {
			if(len == 1) return 1;
			return 9 * count(len-1);
		} else {
			if(len == 1) return 1;
			return 9 * count(len-1) + pow(10, len-1);
		}
	}
	
	private int count(int len) {
		int res = 0;
		for(int i = 1; i <= len; i++) {
			res += i * C(len, i) * pow(9, len-i);
		}
		return res;
	}
	
	private int pow(int a, int b) {
		int res = 1;
		for(int i = 0; i < b; i++) res *= a;
		return res;
	}
	
	private int C(int m, int n) {
		if(n > m-n) n = m-n;
		int upper = 1;
		for(int i = m; m-i <= n-1; i--) {
			upper *= i;
		}
		
		int lower = 1;
		for(int j = 2; j <= n; j++) {
			lower *= j;
		}
		
		return upper / lower;
	}
	
	
	private int largerWithSameLen(int[] arr, int d) {
		int res = 0;
		int prefix = 0;
		for(int i = 0; i < arr.length; i++) {
			if(d > arr[i]) {
				res += count(arr.length-1-i) * (9-arr[i]) + pow(10, arr.length-1-i) + prefix * (9-arr[i]) * pow(10, arr.length-1-i);
			} else {
				res += count(arr.length-1-i) * (9-arr[i]) + prefix * (9-arr[i]) * pow(10, arr.length-1-i);
			}
			
			if(d == arr[i]) prefix++;
			
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		DigitCountinRange test = new DigitCountinRange();
//		System.out.println(test.dcountWithLen(1, 2));
		
		System.out.println(test.digitsCount(3, 100, 250));
//		System.out.println(test.largerWithSameLen(new int [] {1, 3} , 1));
	}
	
}

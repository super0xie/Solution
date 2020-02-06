import java.util.ArrayList;

public class ConfusingNumberII {
	
	
	private int[] digits = {0, 1, 6, 8, 9};
	private int[] map = {0, 1, 0, 0, 0, 0, 9, 0, 8, 6};
	
	public int confusingNumberII(int N) {
        int res = 0;
        ArrayList<Integer> l = new ArrayList<>();
        int n = N;
        while(n > 0) {
        	l.add(n % 10);
        	n = n / 10;
        }
        
        if(l.size() == 1) {
        	if(N < 6) return 0;
        	if(N < 9) return 1;
        	return 2;
        }
        
        int[] d = new int[l.size()];
        for(int i = 0; i < l.size(); i++) d[i] = l.get(l.size()-1-i);
        
        for(int i = 1; i < l.size(); i++) res += total(i)-numOfInvalid(i);
        
        res += totalLessThan(l.size(), d);
        ArrayList<Integer> invalid = new ArrayList<>();
        dfs(l.size(), 0, new int[l.size()],  invalid);
        
        for(int i : invalid) {
        	if(i > N) break;
        	res--;
        }

        return res;
    }
	
	private int totalLessThan(int len, int[] digit) {
		int res = 0;
		int i = 0;
		for(; i < digit.length; i++) {
			int count = 0;
			boolean cont = false;
			for(int j = 0; j < digits.length; j++) {
				if(digits[j] < digit[i]) {
					if(i != 0 || j != 0) count++;
					continue;
				}
				if(digits[j] == digit[i]) 
					cont = true;
				break;
			}
			
			res += count * pow(5, digit.length-1-i);
			if(!cont) break;
		}
		if(i == digit.length) res++;
		
		return res;
	}
	
	
	private void dfs(int len, int i, int[] digit,  ArrayList<Integer> res) {
		if(i >= (len+1) / 2) {
			int n = 0;
			for(int j = 0; j < len; j++) {
				n = n * 10;
				n += digit[j];
			}
			res.add(n);
			return;
		}
		
		int s = 0;
		if(i == 0) {
			s = 1;
		}
		
		if(len % 2 == 1 && i == len/2) {
			for(int d : new int[] {0, 1, 8}) {
				digit[i] = d;
				dfs(len, i+1, digit, res);
			}
		} else {
			for(int j = s; j < digits.length; j++) {
				digit[i] = digits[j];
				digit[len-1-i] = map[digits[j]];
				dfs(len, i+1, digit, res);
			}
		}
		
		
	}
	
	private int pow(int n, int m) {
		int res = 1;
		for(int i = 0; i < m; i++) res *= n;
		return res;
	}
	
	private int numOfInvalid(int len) {
		if(len == 1) return 2;
		int res = 4;
		
		for(int i = 1; i < len/2; i++) {
			res = res * 5; 
		}
		
		if(len % 2 == 1) res *= 3;
		return res;
	}
	
	private int total(int len) {
		if(len == 1) return 4;
		int res = 4;
		for(int i = 1; i < len; i++) res *= 5;
		return res;
	}
	
	public static void main(String[] args) {
		ConfusingNumberII test = new ConfusingNumberII();
		ArrayList<Integer> invalid = new ArrayList<>();
		int len = 9;
        test.dfs(len, 0, new int[len],  invalid);
        for(int i : invalid) System.out.print(i + ", ");
//		System.out.println(test.confusingNumberII(10));
		
	}
	
	
	
	
	
}

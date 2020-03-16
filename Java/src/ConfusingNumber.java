
public class ConfusingNumber {
	
	public boolean confusingNumber(int N) {
        long org = N;
        long tar = 0;
        int[] n = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        
        while(org > 0) {
        	int d = (int)org % 10;
        	if(n[d] < 0) {
        		return false;
        	}else {
        		tar *= 10;
        		tar += n[d];
        		org = org / 10;
        	}
        }
        
        if(tar == (long)N) return false;
        return true;
    }
	
	public static void main(String[] args) {
		ConfusingNumber test = new ConfusingNumber();
		System.out.print(test.confusingNumber(89));
	}
}

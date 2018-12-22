
public class NumberComplement {
	
	public int findComplement(int num) {
        int res = 0;
        int n = 1;
        while(num > 0) {
        	if(num % 2 == 0) {
        		res += n;
        	}
        	n = n * 2;
        	num = num >> 1;
        }
        return res;
    }
	
	public static void main(String[] arsg) {
		NumberComplement test = new NumberComplement();
		test.findComplement(5);
	}
	
}

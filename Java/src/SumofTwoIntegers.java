
public class SumofTwoIntegers {
	public int getSumOld(int a, int b) {
        int res = 0;
        boolean carry = false;
        int m = 1;
        for(int i = 0; i < 32; i++) {
        	boolean bitA = (a & m) != 0;
        	boolean bitB = (b & m) != 0;
        	boolean s = bitA ^ bitB ^ carry;
        	carry = (bitA & bitB) | (carry & (bitA ^ bitB));
        	if(s) {
        		res = res | m;
        	}
        	m = m << 1;
        }
        return res;
    }
	
	public int getSum(int a, int b) {
        int res = a ^ b;
        int carry = a & b;
        if(carry == 0) return res;
        return getSum(res, carry<<1);
    }
	
	public static void main(String[] args) {
		SumofTwoIntegers test = new SumofTwoIntegers();
		System.out.println(test.getSum(-2, 3));
	}
}

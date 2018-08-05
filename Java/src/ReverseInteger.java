
public class ReverseInteger {
	
	int reverse(int x) {
		int upperLimit = Integer.MAX_VALUE / 10;
		int lowerLimit = Integer.MIN_VALUE / 10;
        int result = 0;
        while(x != 0) {
        	int r = x % 10;
        	x = x / 10;
        	if(result > upperLimit || result < lowerLimit)
        		return 0;
        	result = result * 10;
        	result += r;
        }
        return result;
    }
	
	public static void main(String[] args) {
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(-2147483648));
	}

}

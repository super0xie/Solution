
public class ConvertIntegertotheSumofTwoNoZeroIntegers {
	public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        
        for(int i = 1; i <= n/2; i++) {
        	int j = n - i;
        	if(valid(i) && valid(j)) {
        		res[0] = i;
        		res[1] = j;
        		break;
        	}
        }
        	
        return res;
    }
	
	private boolean valid(int i) {
		while(i > 0) {
			if(i % 10 == 0) return false;
			i = i / 10;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ConvertIntegertotheSumofTwoNoZeroIntegers test = new ConvertIntegertotheSumofTwoNoZeroIntegers();
		int[] res = test.getNoZeroIntegers(11);
		System.out.println(res[0] + ", " + res[1]);
	}
}

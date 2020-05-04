

public class FourDivisors {
	
	public int sumFourDivisors(int[] nums) {
		int res = 0;
        for(int i : nums) {
        	int[] ret = getSum(i);
        	if(ret[0] == 4) res+=ret[1];
        }
        	
        return res;
    }
	
	private int[] getSum(int n) {
		int sqrt = (int)Math.sqrt(n);
		int count = 2;
		int sum = n+1;
		int end = sqrt;
		if(sqrt * sqrt == n) {
			sum += sqrt;
			count++;
			end = sqrt-1;
		}
		for(int i = 2; i <= end; i++) {
			if(n % i == 0) {
				sum += i;
				sum += n/i;
				count += 2;
			}
		}
		return new int[] {count, sum};
	}
	
	
	public static void main(String[] args) {
		
		
		
		
	}
	
	
}

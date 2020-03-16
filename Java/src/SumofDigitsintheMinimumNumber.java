
public class SumofDigitsintheMinimumNumber {
	
	public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for(int i : A) {
        	min = Math.min(min, i);
        }
        int sum = 0;
        while(min > 0) {
        	sum += min % 10;
        	min = min / 10;
        }
        
        if(sum % 2 == 1) return 0;
        return 1;
    }
	
}

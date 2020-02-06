
public class FindNumberswithEvenNumberofDigits {
	
	public int findNumbers(int[] nums) {
		int res = 0;
		for(int i : nums) 
			if((i >= 10 && i < 100) || (i >= 1000 && i < 10000)) res++; 
		return res;
	}
}

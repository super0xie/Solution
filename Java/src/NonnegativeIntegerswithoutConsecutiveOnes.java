import java.util.ArrayList;
import java.util.Arrays;

public class NonnegativeIntegerswithoutConsecutiveOnes {
	
	private static int[][] dp = {{0, 0}, {1, 1}, {2, 1}, {3, 2}, {5, 3}, {8, 5}, {13, 8}, {21, 13}, {34, 21}, {55, 34}, {89, 55}, {144, 89}, {233, 144}, {377, 233}, {610, 377}, {987, 610}, {1597, 987}, {2584, 1597}, {4181, 2584}, {6765, 4181}, {10946, 6765}, {17711, 10946}, {28657, 17711}, {46368, 28657}, {75025, 46368}, {121393, 75025}, {196418, 121393}, {317811, 196418}, {514229, 317811}, {832040, 514229}, {1346269, 832040}};

	
	public int findIntegers(int num) {
		
		int n = num;
		ArrayList<Integer> l = new ArrayList<>();
		while(n > 0) {
			l.add(n%2);
			n = n/2;
		}
		
		int len = l.size();
		int[] digits = new int[len];
		
		for(int i = 0; i < len; i++) 
			digits[i] = l.get(len-1-i);
		
		if(len > 2) {
			int res = 2;
			
			for(int i = 2; i < len; i++) {
				res += dp[i][1];
			}
			
			for(int i = 1; i < len; i++) {
				if(digits[i] == 1) {
					int restlen = len-i;
					res += dp[restlen][0];
					
					if(digits[i-1] == 1) break;
				}
			}
			int i = 1;
			for(; i < len; i++) {
				if(digits[i] == 1 && digits[i-1] == 1) break;
			}
			if(i == len) res += 1;
			return res;
		} else {
			if(num < 3) return num+1;
			else return num;
		}
        
    }

		
	public static void main(String[] args) {
		
		int[][] dp = new int[31][2];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i <= 30; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(Arrays.deepToString(dp));
		
	}
}

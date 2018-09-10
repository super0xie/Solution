import java.util.Arrays;

public class NumbersAtMostNGivenDigitSet {
	
	public int atMostNGivenDigitSet(String[] D, int N) {
		
		Arrays.sort(D);
		
        int res = 0;
        String str = String.valueOf(N);
        int cur = D.length;
        int [] dp = new int[str.length()];
        dp[0] = 1;
        for(int i = 1; i < str.length(); i++) {
        	res += cur;
        	dp[i] = cur;
        	cur= cur * D.length;
        }
        
        res += dfs(str, D, dp, 0);
        
        return res;
    }
	
	private int dfs(String str, String[] D, int[] dp, int index) {
		if(index == str.length()) return 1;
		
		int res = 0;
		for(int i = 0; i < D.length; i++) {
			String tar = str.substring(index, index+1);
			if(D[i].compareTo(tar) < 0) {
				res += dp[str.length()-index-1];
			}else if(D[i].compareTo(tar) == 0){
				res += dfs(str, D, dp, index+1);
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] D = {"3","4","5","6"};
		int N = 64;
		
		NumbersAtMostNGivenDigitSet test = new NumbersAtMostNGivenDigitSet();
		System.out.println(test.atMostNGivenDigitSet(D, N));
		
	}

}

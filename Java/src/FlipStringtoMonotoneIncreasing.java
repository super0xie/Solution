
public class FlipStringtoMonotoneIncreasing {
	
	public int minFlipsMonoIncr(String S) {
        int[] leftOne = new int [S.length()];
        int[] rightZero = new int [S.length()];
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
        	leftOne[i] = count;
        	if(S.charAt(i) == '1') count++;
        }
        count = 0;
        for(int i = S.length()-1; i >= 0; i--) {
        	rightZero[i] = count;
        	if(S.charAt(i) == '0') count++;
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i++) {
        	int sum = leftOne[i] + rightZero[i];
        	res = Math.min(res, leftOne[i] + rightZero[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		FlipStringtoMonotoneIncreasing test = new FlipStringtoMonotoneIncreasing();
		System.out.println(test.minFlipsMonoIncr("0101100011"));
	}
	
}

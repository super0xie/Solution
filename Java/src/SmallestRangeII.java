import java.util.Arrays;

public class SmallestRangeII {
	public int smallestRangeII(int[] A, int K) {
		Arrays.sort(A);
        int max = A[A.length-1];
    	int min = A[0];
    	int diff = A[A.length-1] - A[0];
        

    	for(int i = 0; i < A.length-1; i++) {
    		max = Math.max(max, A[i] + 2 * K);
    		min = Math.min(A[0] + 2 * K, A[i+1]);
    		diff = Math.min(diff, max-min);
    	}
    	return diff;
    }
	
	public static void main(String[] args) {
		int[] A = {4,1,8,10};
		SmallestRangeII test = new SmallestRangeII();
		test.smallestRangeII(A, 3);
	}

}

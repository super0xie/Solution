import java.util.Arrays;

public class SquaresofaSortedArray {
	
	public int[] sortedSquares(int[] A) {
		
        int ret = Arrays.binarySearch(A, 0);
        if(ret < 0) {
        	ret = - ret - 1;
        }
        int[] res = new int[A.length];
        int idx = 0;
        
        int i = ret - 1;
        int j = ret;
        
        while(i >= 0 || j < A.length) {
        	if(i >= 0 && j < A.length) {
        		if(Math.abs(A[i]) <= Math.abs(A[j])) {
        			res[idx++] = A[i] * A[i];
        			i--;
        		}else {
        			res[idx++] = A[j] * A[j];
        			j++;
        		}
        	}else if(i >= 0) {
        		res[idx++] = A[i] * A[i];
    			i--;
        	}else {
        		res[idx++] = A[j] * A[j];
    			j++;
        	}
        }
        
        return res;
        
    }
	
	public int[] sortedSquaresBad(int[] A) {
		int[] res = new int[A.length];
		for(int i = 0; i < A.length; i++) {
			res[i] = A[i] * A[i];
		}
		
		Arrays.sort(res);
		return res;
    }
	
	public static void main(String[] args) {
		SquaresofaSortedArray test = new SquaresofaSortedArray();
		int[] A = {-4,-1,0,3,10};
		test.sortedSquares(A);
	}
}

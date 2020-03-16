import java.util.Arrays;

public class TwoSumLessThanK {
	
	public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length-1;
        int res = -1;
        while(i < j) {
        	int sum = A[i] + A[j];
        	if(sum <= K) {
        		res = Math.max(res, sum);
        		i++;
        	}else {
        		j--;
        	}
        }
        return res;
        
    }
	
}

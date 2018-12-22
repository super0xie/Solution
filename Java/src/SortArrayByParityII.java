
public class SortArrayByParityII {
	
	public int[] sortArrayByParityII(int[] A) {
		int i = 0;
		int j = 1;
		
		int[] res = new int[A.length];
		for(int k = 0; k < A.length; k++) {
			if(A[k] % 2 == 0) {
				res[i] = A[k];
				i+=2;
			}else {
				res[j] = A[k];
				j+=2;
			}
		}
		return res;
    }
	
}


public class NumberofSubarrayswithBoundedMaximum {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] >= L && A[i] <= R) {
        		int l = i;
        		int r = i;
        		
        		while(l > 0 && A[l-1] < A[i]) l--;
        		while(r < A.length-1 && A[r+1] <= A[i]) r++;
        		
        		res += (i-l+1) * (r-i+1);
        	}
        }
        return res;
    }
	
	
	
	public static void main(String[] args) {
		NumberofSubarrayswithBoundedMaximum test = new NumberofSubarrayswithBoundedMaximum();
		int[] A = {73,55,36,5,55,14,9,7,72,52};
		System.out.println(test.numSubarrayBoundedMax(A, 32, 69));
	}
}

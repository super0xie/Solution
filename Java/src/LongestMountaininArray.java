import java.util.Arrays;

public class LongestMountaininArray {
	
	public int longestMountain(int[] A) {
        
		int[] start = new int [A.length];
		Arrays.fill(start, -1);
		
		for(int i = 0; i < A.length-1; i++) {
			if(A[i] < A[i+1]) {
				int r = i;
				while(r < A.length-1 && A[r] < A[r+1]) {					
					r++;
					start[r] = i;
				}
				
				i = r;
			}
		}
		int [] end = new int[A.length];
		Arrays.fill(end, -1);
		for(int i = A.length-1; i > 0; i--) {
			if(A[i-1] > A[i]) {
				int l = i;
				while(l > 0 && A[l-1] > A[l]) {					
					l--;
					end[l] = i;
				}
				i = l;
			}
		}
		
		int res = 0;
		for(int i = 1; i < A.length-1; i++) {
			if(A[i] > A[i-1] && A[i] > A[i+1]) {
				if(start[i] != -1 && end[i] != -1) {
					res = Math.max(res, end[i] - start[i] + 1);
				}
			}
			
		}
		
		return res;
		
    }
	
	public static void main(String[] args) {
		int[] A = {2,2,2};
		LongestMountaininArray test = new LongestMountaininArray();
		test.longestMountain(A);
	}
	
}

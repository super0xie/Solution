
public class MonotonicArray {
	
	public boolean isMonotonic(int[] A) {
        if(A.length <= 1) return true;
        boolean inc = false;
        if(A[A.length-1] >= A[0]) inc = true;
        
        for(int i = 1; i < A.length; i++) {
        	if((A[i] >= A[i-1] && inc) || (A[i] <= A[i-1] && !inc)) continue;
        	else return false;
        }
        
        return true;
        
    }

}

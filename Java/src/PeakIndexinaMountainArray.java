
public class PeakIndexinaMountainArray {
	
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        
        while(start <= end) {
        	mid = start + (end - start) / 2;
        	if(mid > 0 && mid < A.length-1 && A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
        	
        	if(mid == 0) start = mid+1;
        	else if(mid == A.length-1) end = mid-1;
        	else {
        		if(A[mid] > A[mid-1]) start = mid+1;
        		else end = mid - 1;
        	}
        }
        
        return -1;
    }
    
}

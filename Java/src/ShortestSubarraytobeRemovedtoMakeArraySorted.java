
public class ShortestSubarraytobeRemovedtoMakeArraySorted {
	
	public int findLengthOfShortestSubarray(int[] arr) {
        int i = 0;
        while(i < arr.length-1 && arr[i] <= arr[i+1]) i++;
        if(i == arr.length-1) return 0;
        int j = arr.length-1;
        while(j > 0 && arr[j] >= arr[j-1]) j--;
        
        if(arr[i] <= arr[j]) return j-i-1;
        
        int l = 1;
        int r = Math.min(i+1, arr.length-j);
        
        while(l < r) {
        	int mid = l + (r-l)/2;
        	
        	
        	int ll = 0;
        	for(; ll <= mid; ll++) {
        		int rr = mid - ll;
        		
        		int il = i-ll;
        		int ir = j+rr;
        		
        		if(arr[il] <= arr[ir]) break;
        	}
        	if(ll == mid+1) l = mid+1;
        	else r = mid;
        }
        
        return j-i-1+l;
    }
	
	public static void main(String[] args) {
		ShortestSubarraytobeRemovedtoMakeArraySorted test = new ShortestSubarraytobeRemovedtoMakeArraySorted();
		int[] arr = {6,10,21,37,34,17,23,18,14,6,26,26,28,40,26,20,33,29,4,17};
		System.out.print(test.findLengthOfShortestSubarray(arr));
	}
	
}

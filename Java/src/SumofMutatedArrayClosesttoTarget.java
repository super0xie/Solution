
public class SumofMutatedArrayClosesttoTarget {
	
	public int findBestValue(int[] arr, int target) {
        int max = 0;
        
        for(int i : arr) max = Math.max(max, i);
        
        int l = 0;
        int r = max;
        
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        
        while(l <= r) {
        	int mid = l + (r-l)/2;
        	
        	int ret = helper(arr, mid);
        	int diff = Math.abs(ret-target);
        	
        	if(diff <= minDiff) {
        		if(diff == minDiff)
        			res = Math.min(res, mid);
        		else
        			res = mid;
        		minDiff = diff;
        	}
        	
        	if(ret > target) {
        		r = mid-1;
        	}else {
        		l = mid+1;
        	}
        	
        }
        
        return res;
    }
	
	private int helper(int[] arr, int n) {
		int sum = 0;
		
		for(int i : arr) {
			if(i > n) sum +=n;
			else sum += i;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		SumofMutatedArrayClosesttoTarget test = new SumofMutatedArrayClosesttoTarget();
		int[] arr = {4,9,3};
		System.out.println(test.findBestValue(arr, 10));
	}
	
}



public class LongestTurbulentSubarray {
	
	public int maxTurbulenceSize(int[] A) {
        int l = 0;
        int r = l;
        
        int res = 1;
        while(l < A.length-1) {
        	boolean lt = false;
        	if(A[l] > A[l+1]) lt = true;
        	else if(A[l] < A[l+1]) lt = false;
        	else {
        		l++;
        		continue;
        	}
        	
        	r = l+1;
        	while(r < A.length-1) {
        		if(lt && A[r] < A[r+1]) {
        			lt = !lt;
        			r++;
        		}else if(!lt && A[r] > A[r+1]) {
        			lt = !lt;
        			r++;
        		}else {
        			break;
        		}
        	}
        	
        	res = Math.max(res, r-l+1);
        	l = r;
        	
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		LongestTurbulentSubarray test = new LongestTurbulentSubarray();
		int[] A = {100};
		System.out.println(test.maxTurbulenceSize(A));
	}
}

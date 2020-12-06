
public class FindaValueofaMysteriousFunctionClosesttoTarget {
	
//	public int closestToTarget(int[] arr, int target) {
//        int res = Integer.MAX_VALUE;
//        
//        for(int i = 0; i < arr.length; i++) {
//        	int l = i;
//        	int r = arr.length-1;
//        	int min = Integer.MAX_VALUE;
//        	while(l < r) {
//        		if(r - l == 1) {
//        			int andl = helper(arr, i, l);
//        			int andr = andl & arr[r];
//        			min = Math.min(Math.abs(target-andl), Math.abs(target-andr));
//        			break;
//        		} else {
//        			int m = l + (r-l)/2;
//        			int anda = helper(arr, i, m-1);
//        			int andb = anda & arr[m];
//        			int andc = andb & arr[m+1];
//        			int diffa = Math.abs(target - anda);
//        			int diffb = Math.abs(target - andb);
//        			int diffc = Math.abs(target - andc);
//        			
//        			if(diffa < diffb && diffb < diffc) {
//        				r = m;
//        			}else if(diffa > diffb && diffb > diffc) {
//        				l = m;
//        			}else {
//        				min = diffb;
//        				break;
//        			}
//        		}
//        	}
//        	
//        	res = Math.min(res, min);
//        }
//        
//        return res;
//    }
//	
//	
//	private int helper(int[] arr, int i, int j) {
//		int res = arr[i];
//		for(int k = i+1; k <= j; k++) {
//			res = res & arr[k];
//		}
//		return res;
//	
//	}

	public int closestToTarget(int[] arr, int target) {
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
        	int ans = arr[i];
        	res = Math.min(res, Math.abs(ans-target));
        	for(int j = i+1; j < arr.length; j++) {
        		ans = ans & arr[j];
        		res = Math.min(res, Math.abs(ans-target));
        		
        		if(res == 0) break;
        		if(ans < target) break;
        	}
        	
        	if(ans > target) break;
        }
        
        return res;
    }
	
	
	public static void main(String[] args) {
		FindaValueofaMysteriousFunctionClosesttoTarget test = new FindaValueofaMysteriousFunctionClosesttoTarget();
		int[] arr = {1,2,4,8,16};
		System.out.print(test.closestToTarget(arr, 0));
	}
	
}

import java.util.HashMap;
import java.util.HashSet;

public class MaximumNumberofAchievableTransferRequests {
	
//	private static HashMap<Integer, Integer> map = new HashMap<>();
//	static {
//		int n = 2;
//		for(int i = 0; i <= 16; i++) {
//			map.put(n-1, i+1);
//			n = n * 2;
//		}
//	}
	
	
	
//	public int maximumRequests(int n, int[][] requests) {
//        int max = (int)Math.pow(2, requests.length)-1;
//        int res = 0;
//
//        for(int i = max; i > 0; i--) {
//        	if(map.containsKey(i) && res >= map.get(i)) break;
//        	
//        	boolean[] mask = new boolean[requests.length];
//        	int k = i;
//        	int count = 0;
//        	for(int j = 0; j < mask.length; j++) {
//        		if(k % 2 == 1) {
//        			mask[j] = true;
//        			count++;
//        		}
//        		k = k >> 1;
//        	}
//        	
//        	if(valid(mask, requests, n)) {
//        		res = Math.max(res, count);
//        	}
//        }
//        return res;
//    }
//	
//	private boolean valid(boolean[] mask, int[][] requests, int n) {
//		int[] count = new int[n];
//		for(int i = 0; i < requests.length; i++) {
//			if(mask[i]) {
//				count[requests[i][0]]--;
//				count[requests[i][1]]++;
//			}
//		}
//		for(int i : count) {
//			if(i != 0) return false;
//		}
//		return true;
//	}
	
	
	public int maximumRequests(int n, int[][] requests) {
        int max = (int)Math.pow(2, requests.length)-1;
        int res = 0;
        for(int i = max; i > 0; i--) res = Math.max(res, helper(i, requests, n));
        return res;
    }
	
	private int helper(int mask, int[][] requests, int n) {
		int[] count = new int[n];
		int m = 1;
		int sum = 0;
		for(int i = 0; i < requests.length; i++) {
			if((m & mask) > 0) {
				count[requests[i][0]]--;
				count[requests[i][1]]++;
				sum++;
			}
			m = m << 1;
		}
		for(int i : count) {
			if(i != 0) return 0;
		}
		return sum;
	}
	
}

import java.util.HashMap;

public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = A.length;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int sum = C[i] + D[j];
        		map.put(sum, map.getOrDefault(sum, 0)+1);
        	}
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		int sum = C[i] + D[j];
        		res += map.getOrDefault(-sum, 0);
        	}
        }
        return res;
    }

}

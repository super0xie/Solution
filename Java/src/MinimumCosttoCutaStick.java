import java.util.Arrays;
import java.util.HashMap;

public class MinimumCosttoCutaStick {
	
//	public int minCost(int n, int[] cuts) {
//		int[] aux = new int[cuts.length+2];
//		for(int i = 0; i < cuts.length; i++) aux[i] = cuts[i];
//		aux[cuts.length] = n;
//		Arrays.parallelSort(aux);
//		
//        return helper(0, n, aux, new HashMap<>());
//    }
//	
//	private int helper(int l, int r, int[] cuts, HashMap<Long, Integer> cache) {
//		long encode = l * 1000001 + r;
//		if(cache.containsKey(encode)) return cache.get(encode);
//		int li = Arrays.binarySearch(cuts, l);
//		int ri = Arrays.binarySearch(cuts, r);
//		
//		if(ri-li == 1) return 0;
//		
//		int res = Integer.MAX_VALUE;
//		for(int i = li+1; i < ri; i++) {
//			int cost = r-l;
//			if(i-li > 1) cost += helper(l, cuts[i], cuts, cache);
//			if(ri-i > 1) cost += helper(cuts[i], r, cuts, cache);
//			res = Math.min(cost, res);
//		}
//		
//		cache.put(encode, res);
//		return res;
//	}
	
	public int minCostdfs(int n, int[] cuts) {
		int[] aux = new int[cuts.length+2];
		for(int i = 0; i < cuts.length; i++) aux[i] = cuts[i];
		aux[cuts.length] = n;
		Arrays.parallelSort(aux);
		
        return helper(0, aux.length-1, aux, new HashMap<>());
    }
	
	private int helper(int l, int r, int[] cuts, HashMap<Integer, Integer> cache) {
		int encode = l * 1000 + r;
		if(cache.containsKey(encode)) return cache.get(encode);
		if(r-l == 1) return 0;
		
		int res = Integer.MAX_VALUE;
		for(int i = l+1; i < r; i++) {
			int cost = cuts[r]-cuts[l];
			if(i-l > 1) cost += helper(l, i, cuts, cache);
			if(r-i > 1) cost += helper(i, r, cuts, cache);
			res = Math.min(cost, res);
		}
		
		cache.put(encode, res);
		return res;
	}
	
	public int minCost(int n, int[] cuts) {
		int[] aux = new int[cuts.length+2];
		for(int i = 0; i < cuts.length; i++) aux[i] = cuts[i];
		aux[cuts.length] = n;
		Arrays.parallelSort(aux);
		int l = aux.length;
		int[][] dp = new int[l][l];
		
		for(int len = 2; len < l; len++) {
			for(int i = 0; i + len < l; i++) {
				int j = i+len;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i+1; k < j; k++) {
					int cost = aux[j]-aux[i] + dp[i][k] + dp[k][j];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
			
		}
		
		return dp[0][l-1];
    }
	
	public static void main(String[] args) {
		MinimumCosttoCutaStick test = new MinimumCosttoCutaStick();
		int[] cuts = {5,6,1,4,2};
		System.out.println(test.minCost(9, cuts));
	}
}

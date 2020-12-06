
public class MinimumNumberofIncrementsonSubarraystoFormaTargetArray {
	
	public int minNumberOperationsOld(int[] target) {
        return helper(target, 0, target.length-1, 0);
    }
	
	private int helper(int[] t, int l, int r, int level) {
		int min = Integer.MAX_VALUE;
		int res = 0;
		for(int i = l; i <= r; i++) 
			min = Math.min(min, t[i]);
		
		res += min - level;
		for(int i = l; i <= r; i++) {
			if(t[i] != min) {
				int j = i+1;
				while(j <= r && t[j] != min) j++;
				res += helper(t, i, j-1, min);
				i = j;
			}
		}
		
		return res;
	}
	
	public int minNumberOperations(int[] target) {
        int res = target[0];
        for(int i = 1; i < target.length; i++) {
        	res += Math.max(target[i]-target[i-1], 0);
        }
        return res;
    }
	
	public static void main(String[] args) {
		MinimumNumberofIncrementsonSubarraystoFormaTargetArray test = new MinimumNumberofIncrementsonSubarraystoFormaTargetArray();
		int[] tar = {1,1,1,1};
		System.out.println(test.minNumberOperations(tar));
	}
	
}

import java.util.Arrays;
import java.util.HashMap;

public class ChalkboardXORGame {
	
	public boolean xorGame(int[] nums) {
		Arrays.sort(nums);
		HashMap<String, Boolean> cache = new HashMap<>();
		boolean res = helper(nums, cache);
		return res;
    }
	
	private boolean helper(int[] nums, HashMap<String, Boolean> cache) {
		if(nums.length == 0) return true;
		
		StringBuilder sb = new StringBuilder();
		for(int i : nums) sb.append(i + ",");
		String encode = sb.toString();
		if(cache.containsKey(encode)) return cache.get(encode);
		
		int n = nums[0];
		for(int i = 1; i < nums.length; i++) n = n ^ nums[i];
		if(n == 0) return true;
		
		for(int i = 0; i < nums.length; i++) {
			int[] sub = new int[nums.length-1];
			int idx = 0;
			for(int j = 0; j < nums.length; j++) {
				if(j == i) continue;
				sub[idx++] = nums[j];
			}
			
			if(!helper(sub, cache)) {
				cache.put(encode, true);
				return true;
			}
		}
		cache.put(encode, false);
		return false;
	}
	
	public static void main(String[] args) {
		ChalkboardXORGame test = new ChalkboardXORGame();
		int[] nums = {10980,3907,5324,8365,2745,3671,11718,12572,11043,3119,8675,1845,10127,15069,5711,13298,13635,1528,7440,9228,14305};
		System.out.println(test.xorGame(nums));
	}

}

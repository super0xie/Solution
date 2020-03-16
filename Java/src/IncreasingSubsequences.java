import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IncreasingSubsequences {
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		helper(nums, 0, l, res, set);
		return res;
    }
	
	private void helper(int[] nums, int idx, List<Integer> l, List<List<Integer>> res, HashSet<String> set) {
		if(idx == nums.length) {
			if(l.size() >= 2) {
				String encode = encode(l);
				if(!set.contains(encode)) {
					List<Integer> aux = new ArrayList<>();
					aux.addAll(l);
					set.add(encode);
					res.add(aux);
				}
			}
			return;
		}
		if(l.size() == 0 || nums[idx] >= l.get(l.size()-1)) {
			l.add(nums[idx]);
			helper(nums, idx+1, l, res, set);
			l.remove(l.size()-1);
		}
		helper(nums, idx+1, l, res, set);
	}
	
	private String encode(List<Integer> l) {
		StringBuilder sb = new StringBuilder();
		for(int i : l) {
			sb.append(i);
			sb.append(',');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		IncreasingSubsequences test = new IncreasingSubsequences();
		int[] nums = {4,6,7,7};
		test.findSubsequences(nums);
	}
}

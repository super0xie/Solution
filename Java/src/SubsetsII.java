import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
	int[] keys;
	int[] counts;
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
        	map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        keys = new int[map.size()];
        counts = new int[map.size()];
        int idx = 0;
        for(int i : map.keySet()) {
        	keys[idx] = i;
        	counts[idx] = map.get(i);
        	idx++;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> l = new LinkedList<>();
        dfs(0, l, res);
        return res;
    }
	
	private void dfs(int i, LinkedList<Integer> l, List<List<Integer>> res) {
		for(int j = 0; j <= counts[i]; j++) {
			int k = j;
			while(k > 0) {
				l.add(keys[i]);
				k--;
			}
			
			if(i == keys.length-1) res.add(new ArrayList<>(l));
			else {
				dfs(i+1, l, res);
			}
			
			k = j;
			while(k > 0) {
				l.removeLast();
				k--;
			}
		}
	}
	
	public static void main(String[] args) {
		SubsetsII test = new SubsetsII();
		int[] nums = {1,2,2};
		test.subsetsWithDup(nums);
	}
}

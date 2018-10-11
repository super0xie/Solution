import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindLeavesofBinaryTree {
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int height = post(root, map);
        
        for(int i = 1; i <= height ; i++) {
        	res.add(map.get(i));
        }
        
        return res;
    }
	
	private int post(TreeNode n, HashMap<Integer, List<Integer>> map) {
		if(n == null) return 0;
		int l = post(n.left, map);
		int r = post(n.right, map);
		
		int res = Math.max(l, r)+1;
		List<Integer> list = map.getOrDefault(res, new ArrayList<Integer>());
		list.add(n.val);
		map.put(res, list);
		
		return res;
	}
	
}

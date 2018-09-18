import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
	
	private HashMap<String, Boolean> map;
	private List<TreeNode> res;
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<String, Boolean>();
        res = new ArrayList<TreeNode>();
        dfs(root);
        return res;
    }
	
	private String dfs(TreeNode node) {
		if(node == null) return "n";
		String l = dfs(node.left);
		String r = dfs(node.right);
		
		String ret = "l" + l + "," + node.val + "," + "r" + r;
		
		if(map.containsKey(ret)) {
			if(!map.get(ret)) {
				res.add(node);
				map.put(ret, true);
			}
		}else {
			map.put(ret, false);
		}
		
		return ret;
	}

}

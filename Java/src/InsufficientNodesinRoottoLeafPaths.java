import java.util.HashSet;
import java.util.Stack;

public class InsufficientNodesinRoottoLeafPaths {

	public TreeNode sufficientSubset(TreeNode root, int limit) {
        HashSet<TreeNode> set = new HashSet<>();
        boolean res = dfs(root, 0, limit);
        
        if(!res) return null;
        return root;
    }

    private boolean dfs(TreeNode n, int sum, int limit) {
		if(n == null) return false;
        int total = sum + n.val;
        boolean res = false;
		if(n.left == null && n.right == null) {
			if(total >= limit) res = true;
			else res = false;
		}else {
			boolean l = dfs(n.left, total, limit);
            boolean r = dfs(n.right, total, limit);
            if(!l) n.left = null;
            if(!r) n.right = null;
			res = l || r;
        }
        
        return res;
	}
	
	private void helper(TreeNode n, HashSet<TreeNode> set) {
		if(n == null) return;
		if(!set.contains(n.left)) n.left = null;
		if(!set.contains(n.right)) n.right = null;
		
		helper(n.left, set);
		helper(n.right, set);
	}
	
	
	
}

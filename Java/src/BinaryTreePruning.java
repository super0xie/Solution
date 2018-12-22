
public class BinaryTreePruning {
	
	public TreeNode pruneTree(TreeNode root) {
        if(helper(root)) return null;
        else return root;
    }
	
	private boolean helper(TreeNode n) {
		if(n == null) return true;
		
		boolean l = helper(n.left);
		boolean r = helper(n.right);
		
		if(n.val == 0 && l && r) return true;
		else {
			if(l) n.left = null;
			if(r) n.right = null;
			return false;
		}
	}
	
}

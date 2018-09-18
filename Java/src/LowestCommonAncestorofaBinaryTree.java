
public class LowestCommonAncestorofaBinaryTree {
	
	TreeNode res;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		
		dfs(root, p, q);
		return res;
    }
	
	private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
		if(node == null) return false;
		if(res != null) return false;
		
		boolean l = dfs(node.left, p, q);
		boolean r = dfs(node.right, p, q);
		
		if(l && r) {
			if(res == null)
				res = node;
			return false;
		}
		if((l || r) && (node.val == p.val || node.val == q.val)) {
			if(res == null)
				res = node;
			return false;
		}
		
		return l || r || node.val == p.val || node.val == q.val;
	}
}

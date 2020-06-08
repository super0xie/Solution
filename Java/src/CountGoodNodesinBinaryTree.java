
public class CountGoodNodesinBinaryTree {
	
	public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
	
	private int dfs(TreeNode n, int max) {
		if(n == null) return 0;
		int res = 0;
		if(n.val >= max) res = 1;
		max = Math.max(max, n.val);
		res += dfs(n.left, max);
		res += dfs(n.right, max);
		
		return res;
	}
	
}

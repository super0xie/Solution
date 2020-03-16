
public class BinarySearchTreetoGreaterSumTree {
	
	private int sum = 0;
	public TreeNode bstToGst(TreeNode root) {
		sum = 0;
        dfs(root);
        return root;
    }
	
	private void dfs(TreeNode n) {
		if(n == null) return;
		dfs(n.right);
		sum += n.val;
		n.val = sum;
		dfs(n.left);
	}
}

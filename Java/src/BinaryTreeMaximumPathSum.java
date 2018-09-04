
public class BinaryTreeMaximumPathSum {
	int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		dfs(root);
        return res;
    }
	
	private int dfs(TreeNode node) {
		if(node == null) return 0;
		int l = dfs(node.left);
		int r = dfs(node.right);
		
		int[] aux = new int [] {l + r + node.val, node.val, node.val+r, node.val+l};
		for(int v : aux) {
			res = Math.max(res, v);
		}
		
		int ret = Integer.MIN_VALUE;
		for(int i = 1; i < aux.length; i++) {
			ret = Math.max(ret, aux[i]);
		}
		return ret;
	}

}

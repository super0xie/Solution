
public class SumofRootToLeafBinaryNumbers {
	
	public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
	
	private int dfs(TreeNode n, int i) {
		if(n == null) return 0;
		
		if(n.left == null && n.right == null) {
			return i * 2 + n.val;
		}
		i = i * 2 + n.val;
				
		return dfs(n.left, i) + dfs(n.right, i);
	}
	
}

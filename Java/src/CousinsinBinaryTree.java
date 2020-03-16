
public class CousinsinBinaryTree {
	
	private TreeNode par;
	private boolean res;
	private int d;
	public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return res;
    }
	
	private void dfs(TreeNode n, int x, int y, int depth) {
		if(n == null) return;
		if(n.left != null && (n.left.val == x || n.left.val == y)) {
			if(par != null) {
				if(n != par && d == depth) res = true;
			}else {
				par = n;
				d = depth;
			}
		}
		
		if(n.right != null && (n.right.val == x || n.right.val == y)) {
			if(par != null) {
				if(n != par && d == depth) res = true;
			}else {
				par = n;
				d = depth;
			}
		}
		
		dfs(n.left, x, y, depth+1);
		dfs(n.right, x, y, depth+1);
	}
	
}

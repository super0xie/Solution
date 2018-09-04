
public class LongestUnivaluePath {
	
	private int res;
	public int longestUnivaluePath(TreeNode root) {
		if(root == null) return 0;
		dfs(root);
        return res;
    }
	
	private int dfs(TreeNode node) {
		if(node == null) return 0;
		
		
		if(node.left != null && node.right != null) {
			int l = dfs(node.left);
			int r = dfs(node.right);
			
			if(node.val == node.left.val && node.val == node.right.val) {
				if(res < l+r+1) res = l+r+1;
				return 1+ Math.max(l, r);
			}else if(node.val == node.left.val){
				if(res < l+1) res = l+1;
				return l+1;
			}else if(node.val == node.right.val) {
				if(res < r+1) res = r+1;
				return r+1;
			}else {
				return 1;
			}
		}else if(node.left == null && node.right == null) {
			if(res < 1) res = 1;
			return 1;
		}else {
			TreeNode n = node.left == null ? node.right : node.left;
			
			int r = dfs(n);
			if(node.val == n.val) {
				if(res < r+1) res = r+1;
				return r+1;
			}else {
				return 1;
			}
		}
		
	}
	
}

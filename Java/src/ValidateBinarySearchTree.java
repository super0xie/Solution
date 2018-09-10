
public class ValidateBinarySearchTree {
	
	boolean res = true;
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        return res;
    }
	
	private int[] dfs(TreeNode node) {
		if(node == null) return null;
		if(!res) return null;
		
		int[] l = dfs(node.left);
		int[] r = dfs(node.right);
		int[] ret = new int [2];
		ret[0] = node.val;
		ret[1] = node.val;
		
		if(l != null) {
			if(node.val <= l[1]) {
				res = false;
				return null;
			}
			ret[0] = l[0];
		}
		
		if(r != null) {
			if(node.val >= r[0]) {
				res = false;
				return null;
			}
			ret[1] = r[1];
		}
		
		return ret;
	}

}

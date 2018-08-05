
public class MinimumAbsoluteDifferenceInBST {
	
	int result = Integer.MAX_VALUE;
	TreeNode lastNodeVisited;
	public int getMinimumDifference(TreeNode root) {
		inorderTraverse(root);
		return result;
    }
	
	private void inorderTraverse(TreeNode root) {
		if(root == null) return;
		
		inorderTraverse(root.left);
		if(lastNodeVisited != null) {
			if(root.val - lastNodeVisited.val < result) {
				result = root.val - lastNodeVisited.val;
			}
		}
		lastNodeVisited = root;
		inorderTraverse(root.right);
		
	}

}

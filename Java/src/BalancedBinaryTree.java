public class BalancedBinaryTree {
	
	Boolean result = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return result;
    }
    
    private int depth(TreeNode root) {
    	if(root == null || !result) return 0;
    	int dl = depth(root.left);
    	int dr = depth(root.right);
    	if(Math.abs(dl-dr) > 1) {
    		result = false;
    		return 0;
    	}
    	int height = Math.max(dl, dr) + 1;
    	return height;
    }
    
    

}

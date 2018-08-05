
public class PathSum {
	
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumHelper(root, sum, 0);
    }
    
    private boolean hasPathSumHelper(TreeNode root, int sum, int currentSum){
    	if(root == null) return false;
    	
    	currentSum += root.val;
    	if(root.left == null && root.right == null && currentSum == sum) return true;
    	
    	return hasPathSumHelper(root.left, sum, currentSum) || hasPathSumHelper(root.right, sum, currentSum);
    }
}

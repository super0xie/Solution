
public class MaximumDifferenceBetweenNodeandAncestor {
	
	public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }
	
	private int helper(TreeNode n, int max, int min) {
		if(n == null) return Integer.MIN_VALUE;
		
		int res = Math.max(Math.abs(max-n.val), Math.abs(min-n.val));
		max = Math.max(max, n.val);
		min = Math.min(min, n.val);
		int left = helper(n.left, max, min);
		int right = helper(n.right, max, min);
		
		return Math.max(res, Math.max(left, right));
		
	}
	
}

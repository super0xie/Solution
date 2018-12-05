
public class MinimumDistanceBetweenBSTNodes {
    
    private int value = Integer.MAX_VALUE;
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return res;
    }
    
    private void helper(TreeNode n) {
        if(n == null) return;
        helper(n.left);
        if(value != Integer.MAX_VALUE) res = Math.min(res, n.val - value);
        value = n.val;
        helper(n.right);
    }
    
}

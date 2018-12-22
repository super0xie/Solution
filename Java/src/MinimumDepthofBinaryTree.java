
public class MinimumDepthofBinaryTree {
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int res = 1;
        if(root.left != null) {
            res = 1 + minDepth(root.left);
        }
        
        if(root.right != null) {
            if(res == 1) res = 1 + minDepth(root.right);
            else {
                res = Math.min(1 + minDepth(root.right), res);
            }
        }
        
        return res;
    }

}

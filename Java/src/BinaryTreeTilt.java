
public class BinaryTreeTilt {
    
    private int t;
    
    public int findTilt(TreeNode root) {
        t = 0;
        dfs(root);
        return t;
    }
    
    private int dfs(TreeNode n) {
        if(n == null) return 0;
        else {
            int l = dfs(n.left);
            int r = dfs(n.right);
            t += Math.abs(l-r);
            return n.val + l + r;
        }
    }
    
}

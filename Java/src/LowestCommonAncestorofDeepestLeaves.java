public class LowestCommonAncestorofDeepestLeaves{

    private int height;
    private TreeNode res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        height = height(root);
        dfs(root, 1);
        return res;
    }

    private int height(TreeNode n){
        if(n == null) return 0;
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    private boolean dfs(TreeNode n, int h){
        if(n == null) return false;

        if(h == height){
            res = n;
            return true;
        }

        boolean l = dfs(n.left, h+1);
        boolean r = dfs(n.right, h+1);

        if(l && r) res = n;
        return l || r;
    }

}
import java.util.LinkedList;

public class SecondMinimumNodeInaBinaryTree {
    
    private int min;
    private int res = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root != null)
            min = root.val;
        dfs(root);
        if(res == Integer.MAX_VALUE) return -1;
        else return res;
    }
    
    private void dfs(TreeNode n) {
        if(n == null) return;
        if(n.val > min) {
            res = Math.min(res, n.val);
        }
        
        dfs(n.left);
        dfs(n.right);
    }
    
}

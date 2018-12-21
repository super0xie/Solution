
public class CheckCompletenessofaBinaryTree {
    
    private boolean res = true;
    
    public boolean isCompleteTree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode n) {
        
        if(n == null) return new int [] {0, 0};
        int[] l = dfs(n.left);
        int[] r = dfs(n.right);
        if(l[0] < r[0] || l[0] - r[0] > 1) res = false;
        if(r[1] > l[1]) res = false;
        if(l[0] == r[0]) {
            if(l[1] != (int)Math.pow(2, r[0])-1) res = false;
        }
        return new int[] {Math.max(l[0], r[0]) + 1, l[1]+r[1]+1};
    }

}

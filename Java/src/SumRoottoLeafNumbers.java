
public class SumRoottoLeafNumbers {
    int result;
    
    
    public int sumNumbers(TreeNode root) {
        result = 0;
        dfs(root, 0);
        
        return result;
        
    }
    
    private void dfs(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            result += sum*10 + root.val;
        }else {
            dfs(root.left, sum*10 + root.val);
            dfs(root.right, sum*10 + root.val);            
        }
    }
}

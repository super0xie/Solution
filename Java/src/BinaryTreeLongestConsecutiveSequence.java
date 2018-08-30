
public class BinaryTreeLongestConsecutiveSequence {
    
    int result = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root != null) {
            dfs(root);
            return result;
        }else {
            return 0;
        }
        
    }
    
    private int dfs(TreeNode node) {
        if(node.left == null && node.right == null) {
            result = Math.max(result, 1);
            return 1;
        }
        
        int res = 1;
        if(node.left != null) {
            int left = dfs(node.left);
            if(node.val + 1 == node.left.val) res=1+left;
        }
        
        if(node.right != null) {
            int right = dfs(node.right);
            if(node.val + 1 == node.right.val) res = Math.max(res, 1+right);
        }
        
        result = Math.max(result, res);
        return res;
    }
}


public class SmallestSubtreewithalltheDeepestNodes {
	
	private int height;
	TreeNode res;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        height = height(root);
        dfs(root, 1);
        
        return res;
    }
    
    private int height(TreeNode n) {
    	if(n == null) return 0;
    	return Math.max(height(n.left), height(n.right)) + 1;
    }
    
    private boolean dfs(TreeNode n, int level) {
    	if(n == null) return false;

    	boolean l = dfs(n.left, level+1);
    	boolean r = dfs(n.right, level+1);
    	
    	if(level == height) {
    		res = n;
    		return true;
    	}
    	
    	if(l && r) {
    		res = n;
    		return true;
    	}else if(l || r) {
    		return true;
    	}else {
    		return false;
    	}
    }

}

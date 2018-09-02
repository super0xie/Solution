import java.util.ArrayList;

public class IncreasingOrderSearchTree {
	
	
	private ArrayList<TreeNode> list;
	public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<TreeNode>();
        dfs(root);
        
        TreeNode current = list.get(0);
        current.left = null;
        current.right = null;
        
        for(int i = 1; i < list.size(); i++) {
        	TreeNode n = list.get(i);
        	n.left = null;
        	n.right = null;
        	current.right = n;
        	current = n;
        }
        
        return list.get(0);
        
        
    }
	
	private void dfs(TreeNode n) {
		if(n == null) return;
		dfs(n.left);
		list.add(n);
		dfs(n.right);
	}
	
}

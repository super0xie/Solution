import java.util.HashSet;

public class FindElementsinaContaminatedBinaryTree {
	
	
	private HashSet<Integer> set;
	public void FindElements(TreeNode root) {
        set = new HashSet<>();
        if(root != null) {
        	root.val = 0;
        	set.add(0);
        	dfs(root);
        }
    }
	
	private void dfs(TreeNode n) {
		if(n.left != null) {
			n.left.val = n.val * 2 + 1;
			set.add(n.left.val);
			dfs(n.left);
		}
		
		if(n.right != null) {
			n.right.val = n.val * 2 + 2;
			set.add(n.right.val);
			dfs(n.right);
		}
	}
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

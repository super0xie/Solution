import java.util.HashSet;

public class TwoSumIVInputisaBST {
	
	public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        return dfs(root, k, set);
        
    }
	
	private boolean dfs(TreeNode n, int k, HashSet<Integer> set) {
		if(n == null) return false;
		if(set.contains(k-n.val)) return true;
		set.add(n.val);
		return dfs(n.left, k, set) || dfs(n.right, k, set);
	}

}

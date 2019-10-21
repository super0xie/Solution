import java.util.HashSet;

public class TwoSumBSTs {
	
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root1, set);
        return helper(root2, set, target);
    }
	
	private void dfs(TreeNode n, HashSet<Integer> set) {
		if(n == null) return;
		set.add(n.val);
		dfs(n.left, set);
		dfs(n.right, set);
	}
	
	private boolean helper(TreeNode n, HashSet<Integer> set, int target) {
		if(n == null) return false;
		if(set.contains(target - n.val)) return true;
		return helper(n.left, set, target) || helper(n.right, set, target);
	}
	
}

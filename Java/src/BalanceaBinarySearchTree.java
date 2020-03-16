import java.util.ArrayList;

public class BalanceaBinarySearchTree {
	
	public TreeNode balanceBST(TreeNode root) {
		ArrayList<Integer> l = new ArrayList<>();
		dfs(root, l);
        return create(l, 0, l.size()-1);
    }
	
	private void dfs(TreeNode n, ArrayList<Integer> l) {
		if(n == null) return;
		dfs(n.left, l);
		l.add(n.val);
		dfs(n.right, l);
	}
	
	private TreeNode create(ArrayList<Integer> list, int l, int r) {
		if(l > r) return null;
		if(l == r) return new TreeNode(list.get(l));
		
		int i = l + (r-l)/2;
		
		TreeNode n = new TreeNode(list.get(i));
		n.left = create(list, l, i-1);
		n.right = create(list, i+1, r);
		return n;
	}
	
}

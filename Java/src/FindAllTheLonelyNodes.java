import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {
	
	public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
	
	private void dfs(TreeNode n, List<Integer> res) {
		if(n == null) return;
		if(n.left != null && n.right == null) res.add(n.left.val);
		if(n.left == null && n.right != null) res.add(n.right.val);
		dfs(n.left, res);
		dfs(n.right, res);
	}
	
}

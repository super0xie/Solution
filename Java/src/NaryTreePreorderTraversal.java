import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	
	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
    }
	
	private void dfs(Node n, List<Integer> res) {
		if(n == null) return;
		res.add(n.val);
		for(Node child : n.children) dfs(child, res);
	}
}

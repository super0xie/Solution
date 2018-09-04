import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<Integer>();
		dfs(root, res);
		return res;
    }
	
	private void dfs(Node n, List<Integer> res) {
		if(n == null) return;
		for(Node child : n.children) {
			dfs(child, res);
		}
		
		res.add(n.val);
	}

}

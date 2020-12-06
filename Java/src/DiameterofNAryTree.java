import java.util.ArrayList;
import java.util.List;

public class DiameterofNAryTree {
	
	class Node {
	    public int val;
	    public List<Node> children;
	    
	    public Node() {
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        children = new ArrayList<Node>();
	    }
	    
	    public Node(int _val,ArrayList<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	private int res = Integer.MIN_VALUE;
	
	public int diameter(Node root) {
		dfs(root);
        return res;
    }
	
	private int dfs(Node n) {
		if(n == null) return 0;
		int h1 = Integer.MIN_VALUE;
		int h2 = Integer.MIN_VALUE;
		for(Node child : n.children) {
			int h = dfs(child);
			if(h > h1) {
				h2 = h1;
				h1 = h;
			}else if(h > h2) {
				h2 = h;
			}
		}
		
		if(h1 == Integer.MIN_VALUE) {
			res = Math.max(res, 0);
			return 1;
		}else if(h1 != Integer.MIN_VALUE && h2 == Integer.MIN_VALUE) {
			res = Math.max(res, h1);
			return h1+1;
		}else {
			res = Math.max(res, h1 + h2);
			return h1+1;
		}
	}
}

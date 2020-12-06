import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindRootofNAryTree {
	
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
	};
	
	public Node findRoot(List<Node> tree) {
        HashSet<Integer> set = new HashSet<>();
        for(Node n : tree) {
        	for(Node c : n.children) {
        		set.add(c.val);
        	}
        }
        for(Node n : tree) {
        	if(!set.contains(n.val)) return n;
        }
        return null;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	public List<List<Integer>> levelOrder(Node root) {
		LinkedList<Node> list = new LinkedList<Node>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null) return res;
		
		list.add(root);
		
		while(!list.isEmpty()) {
			LinkedList<Node> aux = new LinkedList<Node>();
			List<Integer> row = new ArrayList<Integer>();
			while(!list.isEmpty()) {
				Node poped = list.removeFirst();
				row.add(poped.val);
				for(Node n : poped.children) {
					aux.add(n);
				}
			}
			list=aux;
			res.add(row);
		}
		
		return res;
        
    }
}

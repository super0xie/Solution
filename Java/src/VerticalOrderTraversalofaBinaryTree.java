import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree {
	
	private TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		map = new TreeMap<>();
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, 0);
		
		for(int key : map.keySet()) {
			TreeMap<Integer, List<Integer>> col = map.get(key);
			List<Integer> c = new ArrayList<>();
			for(int i : col.keySet()) {
				List<Integer> l = col.get(i);
				Collections.sort(l);
				
				c.addAll(l);
			}
			
			res.add(c);
		}
		
		return res;
    }
	
	private void helper(TreeNode n, int i, int j) {
		if(n == null) return;
		TreeMap<Integer, List<Integer>> col = null;
		if(map.containsKey(j)) {
			col = map.get(j);
		}else {
			col = new TreeMap<>();
			map.put(j, col);
		}
		
		if(col.containsKey(i)) {
			col.get(i).add(n.val);
		}else {
			List<Integer> l = new ArrayList<>();
			l.add(n.val);
			col.put(i, l);
		}
		
		helper(n.left, i+1, j-1);
		helper(n.right, i+1, j+1);
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversalofaBinaryTree test = new VerticalOrderTraversalofaBinaryTree();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		test.verticalTraversal(n1);
	}
	
	
}

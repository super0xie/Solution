import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    	
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	if(root != null)
    		queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		LinkedList<TreeNode> aux = new LinkedList<TreeNode>();
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		while(!queue.isEmpty()) {
    			TreeNode poped = queue.remove();
    			row.add(poped.val);
    			if(poped.left != null) aux.add(poped.left);
    			if(poped.right != null) aux.add(poped.right);
    		}
    		
    		res.addFirst(row);
    		queue = aux;
    		
    	}
    	
    	return res;
    }

}

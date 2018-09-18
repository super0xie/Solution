import java.util.LinkedList;

public class MaximumWidthofBinaryTree {
	
	public int widthOfBinaryTree(TreeNode root) {
		int res = 0;
        if(root != null) res = 1;
        else return 0;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	LinkedList<TreeNode> aux = new LinkedList<TreeNode>();
        	
        	while(!queue.isEmpty()) {
        		TreeNode n = queue.removeFirst();
        		if(n.left != null) {
        			aux.add(n.left);
        		}else {
        			aux.add(new TreeNode(Integer.MIN_VALUE));
        		}
        		
        		if(n.right != null) {
        			aux.add(n.right);
        		}else {
        			aux.add(new TreeNode(Integer.MIN_VALUE));
        		}
        	}
        	
        	while(!aux.isEmpty() && aux.getLast().val == Integer.MIN_VALUE) aux.removeLast();
        	while(!aux.isEmpty() && aux.getFirst().val == Integer.MIN_VALUE) aux.removeFirst();
        	res = Math.max(res, aux.size());
        	
        	queue = aux;
        }
        return res;
        
    }
	
}

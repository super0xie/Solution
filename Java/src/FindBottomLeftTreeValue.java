import java.util.LinkedList;

public class FindBottomLeftTreeValue {
	
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	LinkedList<TreeNode> aux = new LinkedList<>();
        	
    		for(TreeNode n : queue) {
    			if(n.left != null) aux.add(n.left);
    			if(n.right != null) aux.add(n.right);
    		}
        	
        	if(aux.isEmpty()) {
        		return queue.getFirst().val;
        	}else {
        		queue = aux;
        	}
        }
        return -1;
    }
    
}

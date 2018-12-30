import java.util.LinkedList;

public class CheckCompletenessofaBinaryTree {
    
    
    
    public boolean isCompleteTree(TreeNode root) {
        
    	LinkedList<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	int l = 1;
    	while(!q.isEmpty()) {
    		LinkedList<TreeNode> aux = new LinkedList<>();
    		int num = (int)Math.pow(2, l-1);
    		boolean complete = q.size() == num;
    		boolean hasNull = false;
    		for(TreeNode n : q) {
    			if(n.left != null) {
    				if(!complete || hasNull) return false;
    				aux.add(n.left);
    			}else {
    				hasNull = true;
    			}
    			
    			if(n.right != null) {
    				if(!complete || hasNull) return false;
    				aux.add(n.right);
    			}else {
    				hasNull = true;
    			}
    		}
    		
    		q = aux;
    		
    	}
    	
    	
    	
        return true;
    }
    
    

}

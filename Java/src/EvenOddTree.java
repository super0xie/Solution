import java.util.ArrayList;

public class EvenOddTree {
	
	public boolean isEvenOddTree(TreeNode root) {
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        boolean even = true;
        
        while(!q.isEmpty()) {
        	ArrayList<TreeNode> aux = new ArrayList<>();
        	
        	for(int i = 0; i < q.size(); i++) {
        		if(even) {
        			if(q.get(i).val % 2 == 0) return false;
        			if(i > 0 && q.get(i).val <= q.get(i-1).val) return false;
        		}else {
        			if(q.get(i).val % 2 == 1) return false;
        			if(i > 0 && q.get(i).val >= q.get(i-1).val) return false;
        		}
        		
        		if(q.get(i).left != null) aux.add(q.get(i).left);
        		if(q.get(i).right != null) aux.add(q.get(i).right);
        	}
        	
        	q = aux;
        	even = !even;
        }
        
        
        return true;
    }
	
}

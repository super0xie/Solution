import java.util.ArrayList;

public class DeepestLeavesSum {
	
	public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        ArrayList<TreeNode> l = new ArrayList<>();
        l.add(root);
        while(!l.isEmpty()) {
        	ArrayList<TreeNode> aux = new ArrayList<>();
        	res = 0;
        	for(int i = 0; i < l.size(); i++) {
        		res += l.get(i).val;
        		
        		if(l.get(i).left != null) aux.add(l.get(i).left);
        		if(l.get(i).right != null) aux.add(l.get(i).right);
        	}
        	
        	l = aux;
        }
        
        return res;
    }
	
}

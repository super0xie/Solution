import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1  = new ArrayList<Integer>();
        List<Integer> leaves2  = new ArrayList<Integer>();
        getLeaves(root1, leaves1);
        getLeaves(root1, leaves2);
        
        if(leaves1.size() != leaves2.size()) return false;
        
        for(int i = 0; i < leaves1.size(); i++) {
        	if(leaves1.get(i) != leaves2.get(i)) return false;
        }
        
        return true;
    }
	
	private void getLeaves(TreeNode node, List<Integer> leaves) {
		if(node == null) return;
		
		if(node.left == null && node.right == null) leaves.add(node.val);
		else {
			getLeaves(node.left, leaves);
			getLeaves(node.right, leaves);
		}
	}

}

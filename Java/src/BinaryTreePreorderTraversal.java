import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        preorderTraversalHelper(root, result);
        
        return result;
    }
	
	private void preorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
		if(root == null) return;
		result.add(root.val);
		
		preorderTraversalHelper(root.left, result);
		preorderTraversalHelper(root.right, result);
	}

}

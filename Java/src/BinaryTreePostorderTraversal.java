import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	List<Integer> result;
	
	public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        if(root != null)
        	stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode poped = stack.pop();
        	if((poped.left == null || set.contains(poped.left)) && (poped.right == null || set.contains(poped.right)) ) {
        		result.add(poped.val);
        		set.add(poped);
        	}else {
        		stack.push(poped);
        		stack.push(poped.right);
        		stack.push(poped.left);
        	}
        }
        
        return result;
    }
	
	private void helper(TreeNode root) {
		if(root == null) return;
		
		helper(root.left);
		helper(root.right);
		result.add(root.val);
		
	}
	
	
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	List<Integer> result;
	
	public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        if(root != null)
        	stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode poped = stack.pop();
        	if(poped.left == null || set.contains(poped.left)) {
        		result.add(poped.val);
        		set.add(poped);
        		if(poped.right != null)
        			stack.push(poped.right);
        	}else {
        		stack.push(poped);
        		stack.push(poped.left);
        	}
        }
        
        return result;
    }
	
	private void helper(TreeNode root) {
		if(root != null) {
			helper(root.left);
			result.add(root.val);
			helper(root.right);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n1.right = n2;
		n2.left = n3;
		
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		List<Integer> result = test.inorderTraversal(n1);
		
		for(int i : result) {
			System.out.println(i);
		}
		
	}
	
	

}

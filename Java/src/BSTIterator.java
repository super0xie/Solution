import java.util.HashSet;
import java.util.Stack;

public class BSTIterator {
	
	Stack<TreeNode> stack;
	TreeNode next;
	HashSet<TreeNode> set;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        set = new HashSet<TreeNode>();
        if(root != null)
        	stack.add(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode poped = stack.pop();
        if(set.contains(poped)) {
        	if(poped.right != null) stack.push(poped.right);
        	return poped.val;
        }else {
        	set.add(poped);
        	stack.push(poped);
        	if(poped.left != null)
        		stack.push(poped.left);
        	return next();
        }
    }
    
    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(2);
    	TreeNode n2 = new TreeNode(1);
    	n1.left = n2;
    	BSTIterator test = new BSTIterator(n1);
    	
    	while(test.hasNext()) {
    		System.out.println(test.next());
    	}
    	
    }
}

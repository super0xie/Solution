import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryofBinaryTree {
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        
        ArrayList<Integer> left = new ArrayList<Integer>();
        TreeNode p = root.left;
        while(p != null) {
        	left.add(p.val);
        	p = p.left == null? p.right : p.left;
        }
        Stack<Integer> right = new Stack<Integer>();
        p = root.right;
        while(p != null) {
        	right.add(p.val);
        	p = p.right == null ? p.left : p.right;
        }
        
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        dfs(root, leaves);
        
        res.add(root.val);
        if(left.size() == 0 && right.size() == 0) return res;
        
        for(int i : left) {
        	res.add(i);
        }
        
        int start = 0;
        int end = leaves.size()-1;
        
        if(left.size() > 0) start++;
        if(right.size() > 0) end--;
        
        for(int i = start; i <= end; i++) {
        	res.add(leaves.get(i));
        }
        
        while(!right.isEmpty()) {
        	res.add(right.pop());
        }
        
        return res;
    }
	
	private void dfs(TreeNode n, List<Integer> leaves) {
		if(n == null) return;
		if(n.left == null & n.right == null) leaves.add(n.val);
		else {
			dfs(n.left, leaves);
			dfs(n.right, leaves);
		}
	}
}

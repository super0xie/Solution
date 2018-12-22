
public class AddOneRowtoTree {
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(root == null) return null;
        if(d == 1) {
        	TreeNode n = new TreeNode(v);
        	n.left = root;
        	return n;
        }else {
        	helper(root, v, d, 1);
        	return root;
        }
    }
	
	private void helper(TreeNode n, int v, int d, int depth) {
		
		if(n == null) return;
		if(depth == d-1) {
			TreeNode l = n.left;
			TreeNode r = n.right;
			n.left = new TreeNode(v);
			n.right = new TreeNode(v);
			n.left.left = l;
			n.right.right = r;
		}else {
			helper(n.left, v, d, depth+1);
			helper(n.right, v, d, depth+1);
		}
	}
	
	public void main(String[] args) {
		
	}
	
}

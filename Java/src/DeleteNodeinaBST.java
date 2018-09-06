
public class DeleteNodeinaBST {
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		
        if(root.val == key) {
        	if(root.left == null && root.right == null) return null;
        	else if(root.left == null && root.right != null) return root.right;
        	else if(root.left != null && root.right == null) return root.left;
        	else {
        		TreeNode n = root.left;
        		while(n.right != null) n=n.right;
        		n.right = root.right;
        		return root.left;
        	}
        }else {
        	if(key > root.val) root.right = deleteNode(root.right, key);
        	else root.left = deleteNode(root.left, key);
        	return root;
        }
    }
	


}

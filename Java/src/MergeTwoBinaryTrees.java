
public class MergeTwoBinaryTrees {
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
        if(t1 == null && t2 == null) {
        	return null;
        }else if(t1 != null && t2 != null) {
        	t1.val += t2.val;
        	t1.left = mergeTrees(t1.left, t2.left);
        	t1.right = mergeTrees(t1.right, t2.right);
        }else if(t1 == null && t2 != null) {
        	t1 = t2;
        	t1.left = mergeTrees(null, t2.left);
        	t1.right = mergeTrees(null, t2.right);
        }else {
        	t1.left = mergeTrees(t1.left, null);
        	t1.right = mergeTrees(t1.right, null);
        }
        
        return t1;
    }

}

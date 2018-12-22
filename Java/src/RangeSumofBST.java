
public class RangeSumofBST {
	
	public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        int l = rangeSumBST(root.left, L, R);
        int r = rangeSumBST(root.right, L, R);
        
        if(root.val <= R && root.val >= L) {
        	return root.val + l + r;
        }else {
        	return l+r;
        }
    }
	
	
}

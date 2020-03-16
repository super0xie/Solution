
public class ConstructBinarySearchTreefromPreorderTraversal {
	
	public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
	
	private TreeNode helper(int[] pre, int l, int r) {
		TreeNode res = new TreeNode(pre[l]);
		if(l == r) return res;
		else {
			int i = l;
			for(; i <= r; i++) {
				if(pre[i] > pre[l]) break;
			}
			
			if(i > l+1) res.left = helper(pre, l+1, i-1);
			if(i <= r) res.right = helper(pre, i, r);
			return res;
		}
	}

}

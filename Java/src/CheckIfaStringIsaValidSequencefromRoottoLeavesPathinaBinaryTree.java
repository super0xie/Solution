
public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
	
	public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }
	
	private boolean helper(TreeNode n, int[] arr, int idx) {
		if(n == null || idx >= arr.length) return false;
		if(n.val != arr[idx]) return false;
		if(n.left == null && n.right == null && idx == arr.length-1) return true;
		
		return helper(n.left, arr, idx+1) || helper(n.right, arr, idx+1);
	}
}

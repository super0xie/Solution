
public class ConvertSortedArraytoBinarySearchTree {
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
	
	private TreeNode buildTree(int[] nums, int start, int end) {
		if(start > end) return null;
		if(start == end) return new TreeNode(nums[start]);
		int mid = start + (end - start) / 2;
		TreeNode ret = new TreeNode(nums[mid]);
		ret.left = buildTree(nums, start, mid-1);
		ret.right = buildTree(nums, mid+1, end);
		return ret;
	}

}

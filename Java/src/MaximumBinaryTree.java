
public class MaximumBinaryTree {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        
        int maxIdx = start;
        int max = nums[start];
        for(int i = start; i <= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        
        TreeNode n = new TreeNode(max);
        n.left = helper(nums, start, maxIdx-1);
        n.right = helper(nums, maxIdx+1, end);
        return n;
    }
    
    
}

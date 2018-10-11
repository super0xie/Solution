
public class VerifyPreorderSequenceinBinarySearchTree {
    
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
    
    private boolean helper(int[] nums, int start, int end) {
        if(start >= end) return true;
        int root = nums[start];
        
        int i = start + 1;
        while(i <= end && nums[i] < root) i++;
        
        int j = i;
        while(j <= end) {
            if(nums[j] < root) return false;
            j++;
        }
        
        return helper(nums, start+1, i-1) && helper(nums, i, end);
        
    }
    
    public static void main(String[] args) {
        int[] preorder = {5,2,6,1,3};
        VerifyPreorderSequenceinBinarySearchTree test = new VerifyPreorderSequenceinBinarySearchTree();
        System.out.println(test.verifyPreorder(preorder));
    }
    
}

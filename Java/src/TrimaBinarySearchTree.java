
public class TrimaBinarySearchTree {
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val <= R && root.val >= L) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }else if(root.val > R) {
            return trimBST(root.left, L, R);
        }else {
            return trimBST(root.right, L, R);
        }
    }
    
}

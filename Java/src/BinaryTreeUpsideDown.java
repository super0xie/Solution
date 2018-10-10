
public class BinaryTreeUpsideDown {
    
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode l = upsideDownBinaryTree(root.left);
        if(l != null) {
            TreeNode p = l;
            while(p.right != null) p = p.right;
            p.left = root.right;
            p.right = root;
            root.left = null;
            root.right = null;
            return l;
            
        }else {
            return root;
        }
    }
    
    
    
}

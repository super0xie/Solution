public class MaximumBinaryTreeII{

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        if(val > root.val){
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }else{
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }

}
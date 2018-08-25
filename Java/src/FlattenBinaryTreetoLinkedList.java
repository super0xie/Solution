
public class FlattenBinaryTreetoLinkedList {
    
    
    private TreeNode lastNode;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.left);
        TreeNode leftLastNode = lastNode;
        lastNode = root;
        flatten(root.right);
        
        if(root.left != null) {
            TreeNode temp = root.right;
            if(temp == null) lastNode = leftLastNode;
            root.right = root.left;
            root.left = null;
            leftLastNode.right = temp;
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        
        n1.left = n2;
        n2.left = n3;
        FlattenBinaryTreetoLinkedList test = new FlattenBinaryTreetoLinkedList();
        test.flatten(n1);
        
        
    }
    
}

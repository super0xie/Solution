public class BinarySearchTreetoGreaterSumTree{
    private int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        helper(root);
        return root;
    }
    
    private void helper(TreeNode n){
        if(n == null) return;
        helper(n.right);
        int v = n.val;
        n.val += sum;
        sum += v;
        helper(n.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;

        BinarySearchTreetoGreaterSumTree test = new BinarySearchTreetoGreaterSumTree();
        test.bstToGst(n1);
        
        System.out.print("hello");
    }
}
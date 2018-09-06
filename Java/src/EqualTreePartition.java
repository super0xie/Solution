
public class EqualTreePartition {
    
    private int sum;
    private boolean res;
    public boolean checkEqualTree(TreeNode root) {
        res = false;
        sum = dfs(root);
        if(sum%2 != 0) return false;
        dfs2(root);
        return res;
    }
    
    private int dfs(TreeNode n) {
        if(n == null) return 0;
        return n.val + dfs(n.left) + dfs(n.right);
    }
    
    private int dfs2(TreeNode n) {
        if(n == null) return 0;
        int l = dfs2(n.left);
        if(n.left != null && l == sum/2) res = true;
        int r = dfs2(n.right);
        if(n.right != null && r == sum/2) res = true;
        return n.val + l + r;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(1);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n6.left = n7;
        n7.right = n8;
        
        EqualTreePartition test = new EqualTreePartition();
        System.out.println(test.checkEqualTree(n1));
    }
    

}

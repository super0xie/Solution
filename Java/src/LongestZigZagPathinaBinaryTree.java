
public class LongestZigZagPathinaBinaryTree {
    private int res;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, true, true, 0);
        return res;
    }
    
    private void dfs(TreeNode n, boolean fl, boolean fr, int len) {
        if(n == null) return;
        res = Math.max(res, len);
        
        if(fl) dfs(n.right, false, true, len+1);
        else dfs(n.right, false, true, 1);
        
        if(fr) dfs(n.left, true, false, len+1);
        else dfs(n.left, true, false, 1);
    }
    
    public static void main(String[] args) {
//        TreeNode root = CreateBinaryTree.deserialize("1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1");
//        System.out.println("test");
        LongestZigZagPathinaBinaryTree test = new LongestZigZagPathinaBinaryTree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        
        
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        n4.right = n6;
        n5.right = n7;
        n7.right = n8;
        n8.right = n9;
        
        
        
        System.out.print(test.longestZigZag(n1));
    }
    
    
    
}

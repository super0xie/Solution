
public class InorderSuccessorinBST {
    
    private TreeNode cur;
    private TreeNode res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }
    
    private void dfs(TreeNode node, TreeNode p) {
        if(node == null || res != null) return;
        
        
        dfs(node.left, p);
        if(res != null) return;
        if(cur != null) {
            if (cur.val == p.val) {
                res = node;
                return;
            }
        }
        cur = node;
        dfs(node.right, p);
        
    }
    
    public static void main(String[] args) {
        InorderSuccessorinBST test = new InorderSuccessorinBST();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(1);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        
        test.inorderSuccessor(n1, n4);
        
    }
    

}


public class KthSmallestElementinaBST {
    
    
    private int count;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        count = 1;
        res = Integer.MAX_VALUE;
        dfs(root, k);
        return res;
    }
    
    private void dfs(TreeNode n, int k) {
        if(n == null) return;
        
        dfs(n.left, k);
        if(res != Integer.MAX_VALUE) return;
        if(count == k) {
            res = n.val;
            count++;
            return;
        }else {
            count++;
        }
        dfs(n.right, k);
    }
    
    public static void main(String[] args) {
        KthSmallestElementinaBST test = new KthSmallestElementinaBST();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        test.kthSmallest(n1, 1);
    }
    
    

}


public class MaximumSumBSTinBinaryTree {
    
    private int sum = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return sum;
    }
    
    // int[] max, min, sum, isBST
    private int[] dfs(TreeNode n) {
        if(n == null) return null;
        
        
        boolean isBST = true;
        
        int[] l = dfs(n.left);
        int[] r = dfs(n.right);
        
        if(l != null && (l[0] >= n.val || l[3] == 0)) isBST = false;
        if(r != null && (r[1] <= n.val || r[3] == 0)) isBST = false;
        
        int[] res = new int[4];
        if(isBST) {
            res[0] = r == null ? n.val : r[0];
            res[1] = l == null ? n.val : l[1];
            
            int sum = n.val;
            if(l != null) sum += l[2];
            if(r != null) sum += r[2];
            res[2] = sum;
            res[3] = 1;
            
            this.sum = Math.max(this.sum, sum);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(8);
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(-2);
        TreeNode n5 = new TreeNode(6);
        n0.right = n1;
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;
        
        MaximumSumBSTinBinaryTree test = new MaximumSumBSTinBinaryTree();
        System.out.println(test.maxSumBST(n0));
        
    }
    
}

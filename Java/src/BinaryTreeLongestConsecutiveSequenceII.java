
public class BinaryTreeLongestConsecutiveSequenceII {
    
    private int result = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root != null) {
            dfs(root);
            return result;
        }else return 0;
    }
    
    private int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if(node == null) return res;
        
        int inc = 1;
        int dec = 1;
        
        if(node.left != null) {
            int[] resLeft = dfs(node.left);
            if(node.val + 1 == node.left.val) inc = 1 + resLeft[0];
            if(node.val - 1 == node.left.val) dec = 1 + resLeft[1];
        }
        
        if(node.right != null) {
            int[] resRight = dfs(node.right);
            if(node.val + 1 == node.right.val) inc = Math.max(inc, 1 + resRight[0]);
            if(node.val - 1 == node.right.val) dec = Math.max(dec, 1 + resRight[1]);
        }
        
        
        res[0] = inc;
        res[1] = dec;
        
        result = Math.max(result, inc+dec-1);
        
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        
        BinaryTreeLongestConsecutiveSequenceII test = new BinaryTreeLongestConsecutiveSequenceII();
        System.out.println(test.longestConsecutive(n1));
        
    }

}

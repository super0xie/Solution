
public class DiameterofBinaryTree {
	private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode node) {
    	if(node == null) return 0;
    	
    	int l = dfs(node.left);
    	int r = dfs(node.right);
    	
    	res = Math.max(res, l+r);
    	
    	return 1+Math.max(l, r);
    }
    
    public static void main(String[] args) {
    	System.out.println(4/(1-(double)2/3));
    	
    }
}

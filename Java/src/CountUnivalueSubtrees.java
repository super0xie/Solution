
public class CountUnivalueSubtrees {
	
    public int countUnivalSubtrees(TreeNode root) {
        int res = 0;
        res = dfs(root)[0];
        return res;
    }
    
    //return res = int[2] res[0] num, res[1] value 
    private int[] dfs(TreeNode n) {
    	if(n == null) return new int [] {0, Integer.MIN_VALUE};
    	
    	if(n.left == null && n.right == null) {
    		return new int[] {1, n.val};
    	} else if(n.left != null && n.right != null) {
    		int[] left = dfs(n.left);
    		int[] right = dfs(n.right);
    		if(left[1] == right[1] && right[1] == n.val) return new int[] {left[0] + right[0] + 1, n.val};
    		else return new int[] {left[0] + right[0], Integer.MIN_VALUE};
    	}else {
    		int[] res;
    		if(n.left != null)
    			res = dfs(n.left);
    		else
    			res = dfs(n.right);
    		if(res[1] == n.val) return new int[] {1 + res[0], n.val};
    		else return new int[] {res[0], Integer.MIN_VALUE};
    	}
    }
}

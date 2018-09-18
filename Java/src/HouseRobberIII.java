
public class HouseRobberIII {
	public int rob(TreeNode root) {
		int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
	
	private int[] dfs(TreeNode n) {
		if(n == null) return new int[] {0, 0};
		
		int[] l = dfs(n.left);
		int[] r = dfs(n.right);
		
		int[] ret = new int[2];
		
		ret[0] = n.val + l[1] + r[1];
		ret[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
		
		return ret;
	}
}

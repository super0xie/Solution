
public class PseudoPalindromicPathsinaBinaryTree {
	
	public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count);
    }
	
	private int dfs(TreeNode n, int[] count) {
		if(n == null) return 0;
		if(n.left == null && n.right == null) {
			count[n.val]++;
			int ret = 0;
			int odd = 0;
			for(int i : count) {
				if(i % 2 == 1) odd++;
			}
			if(odd > 1) ret = 0;
			else ret = 1;
			count[n.val]--;
			return ret;
		}else {
			count[n.val]++;
			int ret = dfs(n.left, count) + dfs(n.right, count);
			count[n.val]--;
			return ret;
		}
	}
	
}

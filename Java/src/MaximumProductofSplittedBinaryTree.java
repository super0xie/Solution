import java.util.ArrayList;

public class MaximumProductofSplittedBinaryTree {
	
	public int maxProduct(TreeNode root) {
		ArrayList<Integer> arr = new ArrayList<>();
		dfs(root, arr);
		
		int n = arr.get(arr.size()-1);
		int min = Integer.MAX_VALUE;
		int idx = -1;
		
		for(int i = 0; i < arr.size()-1; i++) {
			int abs = Math.abs(arr.get(i)-n/2);
			if(abs < min) {
				min = abs;
				idx = i;
			}
		}
		
		return (int)(((n-arr.get(idx)) * (long)arr.get(idx)) % 1000000007);
    }
	
	private int dfs(TreeNode n, ArrayList<Integer> arr) {
		if(n == null) return 0;
		int l = dfs(n.left, arr);
		int r = dfs(n.right, arr);
		
		int res = l + r + n.val;
		arr.add(res);
		return res;
	}
}

import java.util.HashMap;

public class BinaryTreeCameras {
	
	private HashMap<TreeNode, int[]> cache = new HashMap<>();
	
	public int minCameraCover(TreeNode root) {
		
        return helper(root, false, false);
    }
	
	private int helper(TreeNode n, boolean covered, boolean force) {
		if(n == null) return 0;
		
		if(force) {
			return 1 + helper(n.left, true, false) + helper(n.right, true, false);
		}else {
			
			
			if(covered) {
				if(cache.containsKey(n) && cache.get(n)[0] > 0) return cache.get(n)[0];
				int a = 1 + helper(n.left, true, false) + helper(n.right, true, false);
				int b = helper(n.left, false, false) + helper(n.right, false, false);
				
				if(!cache.containsKey(n)) cache.put(n, new int[2]);
				cache.get(n)[0] = Math.min(a, b);
				return Math.min(a, b);
			} else {
				
				if(cache.containsKey(n) && cache.get(n)[1] > 0) return cache.get(n)[1];
				int res = 0;
				
				if(n.left == null && n.right == null) res = 1;
				else if(n.left == null && n.right != null) {
					int a = 1 + helper(n.right, true, false);
					int b = helper(n.right, false, true);
					res = Math.min(a, b);
				}else if(n.left != null && n.right == null) {
					int a = 1 + helper(n.left, true, false);
					int b = helper(n.left, false, true);
					res = Math.min(a, b);
				}else {
					int a = 1 + helper(n.left, true, false) + helper(n.right, true, false);
					
					int r1 = helper(n.left, false, true);
					int r2 = helper(n.right, false, true);
					int r3 = helper(n.left, false, false);
					int r4 = helper(n.right, false, false);
					
					int b = r1 + r2;
					int c = r1 + r4;
					int d = r2 + r3;
					
					res = Math.min(a, Math.min(b, Math.min(c, d)));
				}
				
				if(!cache.containsKey(n)) cache.put(n, new int[2]);
				cache.get(n)[1] = res;
				return res;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		BinaryTreeCameras test = new BinaryTreeCameras();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n2.right = n3;
		n3.left = n4;
		n4.right = n5;
		n5.left = n6;
		
		
		System.out.println(test.minCameraCover(n1));
	}
	
}

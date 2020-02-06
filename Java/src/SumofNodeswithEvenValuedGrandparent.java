
public class SumofNodeswithEvenValuedGrandparent {
	
	public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1);
    }
	
	private int helper(TreeNode n, int g, int p) {
		if(n == null) return 0; 
		
		int sum = 0;
		if(g % 2 == 0) {
			sum += n.val;
		}
		
		sum += helper(n.left, p, n.val);
		sum += helper(n.right, p, n.val);
		
		return sum;
	}
	
}

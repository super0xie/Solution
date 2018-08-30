
public class SplitBST {
	
	public TreeNode[] splitBST(TreeNode root, int V) {
		if(root == null) {
			return new TreeNode[] {null, null};
		}
        
        if(root.val <= V) {
        	TreeNode[] res = splitBST(root.right, V);
        	root.right = res[0];
        	return new TreeNode[] {root, res[1]};
        }else {
        	TreeNode[] res = splitBST(root.left, V);
        	root.left = res[1];
        	return new TreeNode[] {res[0], root};
        }
    }
	
	
	public static void main(String[] args) {
		
		int[] a = null;
		System.out.println(a==null);
	}
}

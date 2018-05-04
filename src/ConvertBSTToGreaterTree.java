
public class ConvertBSTToGreaterTree {
	
	private int sum;
	
	public TreeNode convertBST(TreeNode root) {
		sum = 0;
		rmlTraverse(root);
		
        return root;
    }
	
	private void rmlTraverse(TreeNode root) {
		if(root == null) return;
		
		rmlTraverse(root.right);
		int temp = root.val;
		root.val += sum;
		sum += temp;
		rmlTraverse(root.left);
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		
		ConvertBSTToGreaterTree test = new ConvertBSTToGreaterTree();
		test.convertBST(root);
		
		System.out.println("hello");
	}

}

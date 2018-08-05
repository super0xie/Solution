
public class ConstructBinaryTreeFromPreorderandInorderTraversal {
	
	int counter = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

        return helper(0, inorder.length - 1, preorder, inorder);
    }
	
	
	private TreeNode helper(int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
		int rootValue = preorder[counter];
		TreeNode n = new TreeNode(rootValue);
		counter++;
		int i;
		for(i = inorderStart; i <= inorderEnd; i++) {
			if(inorder[i] == rootValue) break;
		}
		
		if(i - inorderStart > 0) {
			n.left = helper(inorderStart, i-1, preorder, inorder);
		}
		
		if(inorderEnd - i > 0) {
			n.right = helper(i+1, inorderEnd, preorder, inorder);
		}
		
		return n;	
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderandInorderTraversal test = 
				new ConstructBinaryTreeFromPreorderandInorderTraversal();
		
		int [] preorder = {3,9,20,15,7};
		int [] inorder = {9,3,15,20,7};
		
		TreeNode root = test.buildTree(preorder, inorder);
		
		System.out.println("test");
	}

}

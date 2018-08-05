
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	int counter;
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
		counter = postorder.length - 1;
		return  helper(0, inorder.length - 1, inorder, postorder);
		
    }
	
	private TreeNode helper(int inorderStart, int inorderEnd, int[] inorder, int[] postorder) {
		int rootValue = postorder[counter];
		int i;
		TreeNode n = new TreeNode(rootValue);
		counter--;
		
		for(i = inorderStart; i <= inorderEnd; i++) {
			if(inorder[i] == rootValue) break;
		}
		
		if(inorderEnd - i > 0) {
			n.right = helper(i+1, inorderEnd, inorder, postorder);
		}
		
		if(i - inorderStart > 0) {
			n.left = helper(inorderStart, i-1, inorder, postorder);
		}
		return n;	
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal test = 
				new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		
		int [] postorder = {9,15,7,20,3};
		int [] inorder = {9,3,15,20,7};
		
		TreeNode root = test.buildTree(inorder, postorder);
		
		System.out.println("test");
	}

}

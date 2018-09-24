
public class ConstructBinaryTreefromPreorderandPostorderTraversal {
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode res = helper(pre, post, 0, pre.length-1, 0, post.length-1);
        return res;
    }
	
	private TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {
		if(preStart > preEnd) return null;
		TreeNode n = new TreeNode(pre[preStart]);
		//find left and right range
		if(preStart == preEnd) return n;
		int leftRoot = pre[preStart+1];
		int i = postStart;
		while(post[i] != leftRoot) i++;
		int leftLength = i - postStart + 1;
		
		n.left = helper(pre, post, preStart+1, preStart+leftLength, postStart, postStart+leftLength-1);
		n.right = helper(pre, post, preStart+leftLength+1, preEnd, postStart+leftLength, postEnd-1);
		return n;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] post = {4,5,2,6,7,3,1};
		ConstructBinaryTreefromPreorderandPostorderTraversal test = new ConstructBinaryTreefromPreorderandPostorderTraversal();
		test.constructFromPrePost(pre, post);
	}

}

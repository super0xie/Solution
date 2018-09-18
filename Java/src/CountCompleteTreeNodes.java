
public class CountCompleteTreeNodes {
	
	private int getHeight(TreeNode node) {
		if(node == null) return 0;
		else return 1 + getHeight(node.left);
	}
	
	public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if(l > r) {
        	int aux = 1 + (r == 0 ? 0 : ((1<<r) - 1));
        	int res = aux + countNodes(root.left);
        	return res;
        }else {
        	int aux = 1 + (l == 0 ? 0 : ((1<<l) - 1));
        	int res = aux + countNodes(root.right);
        	return res;
        }
        	
    }
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
		CountCompleteTreeNodes test = new CountCompleteTreeNodes();
		System.out.println(test.countNodes(n1));
		
		System.out.println(1<<2);
		
	}

}

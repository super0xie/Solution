
public class SubtreeofAnotherTree {
	

    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if(s == null) return false;

    	if(isSame(s,t)) return true;
    	else return isSubtree(s.left, t) || isSubtree(s.right, t);
        
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
    	if(s == null && t == null) return true;
        else if(s != null && t != null) {
        	if(s.val == t.val) {
        		return isSame(s.left, t.left) && isSame(s.right, t.right);
        	}else {
        		return false;
        	}
        }else {
        	return false;
        }
    }
    
    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
//        TreeNode n4 = new TreeNode(1);
//        TreeNode n5 = new TreeNode(2);
//        TreeNode n6 = new TreeNode(4);
//        TreeNode n7 = new TreeNode(1);
//        TreeNode n8 = new TreeNode(2);
        
        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
        
//        n4.left = n5;
//        n6.right = n8;
        
        SubtreeofAnotherTree test = new SubtreeofAnotherTree();
        test.isSubtree(n1, n3);
    	
    }

}

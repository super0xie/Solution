import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        
        q1.add(root);
        
        while(!q1.isEmpty()) {
        	
        	ArrayList<Integer> list = new ArrayList<Integer>();
            while(!q1.isEmpty()) {
            	
            	TreeNode n = q1.remove();
            	list.add(n.val);
            	
            	if(n.left != null) q2.add(n.left);
            	if(n.right != null) q2.add(n.right);
            }
            result.add(list);
            
            LinkedList<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        return result;
    }

}

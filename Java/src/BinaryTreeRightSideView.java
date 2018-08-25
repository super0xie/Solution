import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.add(root);
        
        while(!queue.isEmpty()) {
            
            LinkedList<TreeNode> auxQueue = new LinkedList<TreeNode>();
            TreeNode lastNode = null;
            while(!queue.isEmpty()) {
                TreeNode poped = queue.poll();
                lastNode = poped;
                
                if(poped.left != null) {
                    auxQueue.add(poped.left);
                }
                
                if(poped.right != null) {
                    auxQueue.add(poped.right);
                }   
            }
            
            result.add(lastNode.val);
            queue = auxQueue;
        }
        
        return result;
    }

}

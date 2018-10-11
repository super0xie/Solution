import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueinEachTreeRow {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        
        while(!queue.isEmpty()) {
            LinkedList<TreeNode> aux = new LinkedList<>();
            
            int max = Integer.MIN_VALUE;
            while(!queue.isEmpty()) {
                TreeNode n = queue.poll();
                max = Math.max(n.val, max);
                if(n.left != null) aux.add(n.left);
                if(n.right != null) aux.add(n.right);
                
            }
            
            res.add(max);
            queue = aux;
        }
        
        return res;
    }
    
}

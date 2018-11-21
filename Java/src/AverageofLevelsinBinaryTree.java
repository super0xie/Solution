import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageofLevelsinBinaryTree {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            LinkedList<TreeNode> aux = new LinkedList<>();
            long sum = 0;
            int c = q.size();
            while(!q.isEmpty()) {
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left != null) aux.add(n.left);
                if(n.right != null) aux.add(n.right);
            }
            res.add((double)sum/c);
            q = aux;
        }
        return res;
    }
    
}

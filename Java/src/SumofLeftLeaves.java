import java.util.LinkedList;

public class SumofLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        int sum = 0;
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n.left != null) {
                if(n.left.left == null && n.left.right == null)
                    sum += n.left.val;
                q.add(n.left);
            }
            if(n.right != null) q.add(n.right);
        }
        return sum;
    }
    
}

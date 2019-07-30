import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    private List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        if(root == null) return res;
        boolean[] delete = new boolean[1001];
        for(int i : to_delete)
            delete[i] = true;
        
        if(!delete[root.val]) res.add(root);
        helper(root, delete);
        
        return res;
    }

    private void helper(TreeNode n, boolean[] delete){
        if(n == null) return;

        TreeNode l = n.left;
        TreeNode r = n.right;
        if(l != null){
            if(delete[l.val])
                n.left = null;
            else if(delete[n.val])
                res.add(l);
            helper(l, delete);
        }
        
        if(r != null){
            if(delete[r.val])
                n.right = null;
            else if(delete[n.val])
                res.add(r);
            helper(r, delete);
        }

    }
    
}
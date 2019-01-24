import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    private int idx = 0;
    private List<Integer> res;
    private boolean fail;
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        res = new ArrayList<>();
        helper(root, voyage);
        
        if(fail) {
            res.clear();
            res.add(-1);
        }
        
        return res;
    }
    
    private void helper(TreeNode n, int[] v) {
        if(fail || n == null) return;
        
        if(idx >= v.length || n.val != v[idx]) {
            fail = true;
            return;
        }
        
        idx++;
        
        if(n.left != null) {
            if(idx >= v.length) {
                fail = true;
                return;
            }
            
            if(n.left.val != v[idx]) {
                TreeNode aux = n.left;
                n.left = n.right;
                n.right = aux;
                res.add(n.val);
            }
        }
        
        helper(n.left, v);
        if(fail) return;
        helper(n.right, v);
    }
    
    public static void main(String[] args) {
        System.out.println((-4%5));
    }
    
    
    
}

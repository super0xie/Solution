import java.util.ArrayList;

public class PathSumIII {
    
    int res;
    int sum;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        res = 0;
        helper(root, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(TreeNode n, ArrayList<Integer> v) {
        if(n == null) return;
        v.add(n.val);
        
        int s = 0;
        for(int i = v.size()-1; i >= 0; i--) {
            s += v.get(i);
            if(s == sum) res++;
        }
        
        helper(n.left, v);
        helper(n.right, v);
        
        v.remove(v.size()-1);
    }
    
}

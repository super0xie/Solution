import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {
    
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        LinkedList<TreeNode> l = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        l.add(root);
        c.add(0);
        while(!l.isEmpty()) {
            TreeNode n = l.poll();
            int i = c.poll();
            min = Math.min(min, i);
            max = Math.max(max, i);
            
            if(map.containsKey(i)) {
                map.get(i).add(n.val);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(n.val);
                map.put(i, list);
            }
            
            if(n.left != null) {
                l.add(n.left);
                c.add(i-1);
            }
            if(n.right != null) {
                l.add(n.right);
                c.add(i+1);
            }
        }
        for(int i = min; i <= max; i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
    
    
}

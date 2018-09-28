import java.util.ArrayList;
import java.util.HashMap;

public class FindModeinBinarySearchTree {
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        dfs(root, count);
        int max = Integer.MIN_VALUE;
        for(int key : count.keySet()) {
            max = Math.max(max, count.get(key));
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int key : count.keySet()) {
            if(count.get(key) == max) list.add(key);
        }
        
        int[] res = new int [list.size()];
        int idx = 0;
        for(int num : list) {
            res[idx++] = num;
        }
        return res;
    }
    
    private void dfs(TreeNode n, HashMap<Integer, Integer> count) {
        if(n == null) return;
        count.put(n.val, count.getOrDefault(n.val, 0)+1);
        dfs(n.left, count);
        dfs(n.right, count);
    }
    
}

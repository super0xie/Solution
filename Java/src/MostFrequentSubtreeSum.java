import java.util.ArrayList;
import java.util.HashMap;

public class MostFrequentSubtreeSum {
    private HashMap<Integer, Integer> map;
    private int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        
        dfs(root);
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int key : map.keySet()) {
            if(map.get(key) == max) res.add(key);
        }
        
        int[] ret = new int[res.size()];
        int idx = 0;
        for(int i : res) {
            ret[idx++] = i;
        }
        
        return ret;
    }
    
    private int dfs(TreeNode n) {
        if(n == null) return 0;
        
        int l = dfs(n.left);
        int r = dfs(n.right);
        
        int sum = n.val + l + r;
        int count = map.getOrDefault(sum, 0)+1;
        max = Math.max(max, count);
        map.put(sum, count);
        return sum;
    }
}

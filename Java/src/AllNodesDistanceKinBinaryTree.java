import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {
	
	private HashSet<Integer> res;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new HashSet<Integer>();
        
        dfsLMR(root, target, Integer.MAX_VALUE, K);
        dfsRML(root, target, Integer.MAX_VALUE, K);
        
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int num : res) ret.add(num);
        return ret;
    }
	
	private int dfsLMR(TreeNode n, TreeNode target, int dis, int K) {
		if(n == null) return Integer.MAX_VALUE;
		if(n == target) dis = 0;
		
		int l = 0;
		if(dis != Integer.MAX_VALUE) l = dfsLMR(n.left, target, dis+1, K);
		else l = dfsLMR(n.left, target, Integer.MAX_VALUE, K);
		
		int r = 0;
		if(dis == Integer.MAX_VALUE && l == Integer.MAX_VALUE) r = dfsLMR(n.right, target, Integer.MAX_VALUE, K);
		else if(dis != Integer.MAX_VALUE) r = dfsLMR(n.right, target, dis+1, K);
		else r = dfsLMR(n.right, target, l+2, K);
		
		int ret = 0;
		if(dis == Integer.MAX_VALUE && l == Integer.MAX_VALUE && r == Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
		else if(dis != Integer.MAX_VALUE) ret = dis;
		else if(l != Integer.MAX_VALUE) ret = l+1;
		else ret = r+1;
		
		if(ret == K) res.add(n.val);
		return ret;
	}
	
	private int dfsRML(TreeNode n, TreeNode target, int dis, int K) {
		if(n == null) return Integer.MAX_VALUE;
		if(n == target) dis = 0;
		
		int r = 0;
		if(dis != Integer.MAX_VALUE) r = dfsRML(n.right, target, dis+1, K);
		else r = dfsRML(n.right, target, Integer.MAX_VALUE, K);
		
		int l = 0;
		if(dis == Integer.MAX_VALUE && r == Integer.MAX_VALUE) l = dfsRML(n.left, target, Integer.MAX_VALUE, K);
		else if(dis != Integer.MAX_VALUE) l = dfsRML(n.left, target, dis+1, K);
		else l = dfsRML(n.left, target, r+2, K);
		
		int ret = 0;
		if(dis == Integer.MAX_VALUE && l == Integer.MAX_VALUE && r == Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
		else if(dis != Integer.MAX_VALUE) ret = dis;
		else if(r != Integer.MAX_VALUE) ret = r+1;
		else ret = l+1;
		
		if(ret == K) res.add(n.val);
		return ret;
	}

}

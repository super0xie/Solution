import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees {
	
//	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
//		ArrayList<Integer> l = new ArrayList<>();
//        dfs(root1, l);
//        dfs(root2, l);
//        Collections.sort(l);
//        return l;
//    }
//	
//	
//	private void dfs(TreeNode n, ArrayList<Integer> l) {
//		if(n == null) return;
//		
//		l.add(n.val);
//		dfs(n.left, l);
//		dfs(n.right, l);
//	}
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();
        dfs(root1, l);
        dfs(root2, r);
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < l.size() || j < r.size()) {
        	if(i < l.size() && j < r.size()) {
        		if(l.get(i) < r.get(j)) res.add(l.get(i++));
        		else res.add(r.get(j++));
        	}else if(i < l.size()) {
        		res.add(l.get(i++));
        	}else {
        		res.add(r.get(j++));
        	}
        }
        
        return res;
    }
	
	
	private void dfs(TreeNode n, ArrayList<Integer> l) {
		if(n == null) return;
		dfs(n.left, l);
		l.add(n.val);
		dfs(n.right, l);
	}
}

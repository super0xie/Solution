import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeInserter {
	
	private List<List<TreeNode>> list;
	
	public void CBTInserter(TreeNode root) {
		list = new ArrayList<List<TreeNode>>();
		List<TreeNode> l = new ArrayList<TreeNode>();
		l.add(root);
		list.add(l);
		List<TreeNode> pre = l;
		while(true) {
			List<TreeNode> aux = new ArrayList<TreeNode>();
			for(TreeNode n : pre) {
				if(n.left != null) aux.add(n.left);
				if(n.right != null) aux.add(n.right);
			}
			if(aux.isEmpty()) break;
			else {
				list.add(aux);
				pre = aux;
			}
		}
    }
    
    public int insert(int v) {
        int height = list.size();
        int fillSize = 1 << (height-1);
        
        if(list.get(list.size()-1).size() == fillSize) {
        	list.add(new ArrayList<TreeNode>());
        }
        TreeNode n = new TreeNode(v);
        list.get(list.size()-1).add(n);
        int idx = list.get(list.size()-1).size()-1;
        int parentIdx = idx / 2;
        TreeNode parent = list.get(list.size()-2).get(parentIdx);
        if(idx % 2 == 0) parent.left = n;
        else parent.right = n;
        return list.get(list.size()-2).get(parentIdx).val;
    }
    
    public TreeNode get_root() {
        return list.get(0).get(0);
    }
}

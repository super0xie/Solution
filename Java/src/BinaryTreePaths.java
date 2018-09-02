import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	
    public List<String> binaryTreePaths(TreeNode root) {
        return dfs(root);
    }
    
    private ArrayList<String> dfs(TreeNode n){
    	if(n == null) return new ArrayList<String>();
    	
    	ArrayList<String> res = new ArrayList<String>();
    	if(n.left == null && n.right == null) {
    		res.add(n.val+"");
    		return res;
    	}
    	
    	ArrayList<String> left = dfs(n.left);
    	ArrayList<String> right = dfs(n.right);
    	
    	for(String str : left) {
    		res.add(n.val + "->" + str);
    	}
    	
    	for(String str : right) {
    		res.add(n.val + "->" + str);
    	}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	TreeNode n1 = new TreeNode(1);
    	n1.left = new TreeNode(2);
    	n1.right = new TreeNode(3);
    	
    	BinaryTreePaths test = new BinaryTreePaths();
    	test.binaryTreePaths(n1);
    }
    
}

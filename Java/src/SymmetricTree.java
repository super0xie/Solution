import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    
    List<Integer> list;
    public boolean isSymmetric(TreeNode root) {
        list = new ArrayList<Integer>();
        
        if(root == null) return true;
        
        if((root.left==null && root.right != null)
            || (root.left != null && root.right == null)
            || (root.left != null && root.right != null && root.left.val != root.right.val)) return false;
        
        
        
        dfs(root);
       
        
        for(int i = 0; i < list.size() / 2; i++) {
            int a = list.get(i);
            int b = list.get(list.size()-1-i);
            if(a != b) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
 
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        
        SymmetricTree test = new SymmetricTree();
        System.out.println(test.isSymmetric(n1));
        
        
    }
    
    
}

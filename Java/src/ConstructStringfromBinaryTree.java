
public class ConstructStringfromBinaryTree {
    
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }else if(t.left == null && t.right != null) {
            String r = tree2str(t.right);
            return t.val + "()" + "(" + r + ")";
        }else if(t.left != null && t.right == null) {
            String l = tree2str(t.left);
            return t.val + "(" + l + ")";
        }else {
            String l = tree2str(t.left);
            String r = tree2str(t.right);
            return t.val + "(" + l + ")(" + r + ")";
        }
    }
    
}

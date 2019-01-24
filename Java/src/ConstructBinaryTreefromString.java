
public class ConstructBinaryTreefromString {
    
    public TreeNode str2tree(String s) {
        return helper(s, 0, s.length()-1);
    }
    
    private TreeNode helper(String s, int l, int r) {
        if(r < l) return null;
        int i = l;
        while(i <= r) {
            if(s.charAt(i) == '(') break;
            i++;
        }
        
        int val = Integer.parseInt(s.substring(l, i));
        TreeNode n = new TreeNode(val);
        if(i > r) return n;
        
        int j = i+1;
        int count = 1;
        while(j <= r) {
            if(s.charAt(j) == '(') count++;
            if(s.charAt(j) == ')') count--;
            if(count == 0) break;
            j++;
        }
        
        n.left = helper(s, i+1, j-1);
        if(j < r) n.right = helper(s, j+2, r-1);
        return n;
    }
    
    public static void main(String[] args) {
        ConstructBinaryTreefromString test = new ConstructBinaryTreefromString();
        test.str2tree("4(2(3)(1))(6(5))");
    }
    
}

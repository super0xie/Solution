import java.util.ArrayList;
import java.util.List;

public class EncodeNaryTreetoBinaryTree {
    
    class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode ret = new TreeNode(root.val);
        
        TreeNode p = ret;
        for(Node n : root.children) {
            if(p == ret) {
                p.left = encode(n);
                p = p.left;
            }else {
                p.right = encode(n);
                p = p.right;
            }
        }
        
        return ret;
    }

    
    public Node decode(TreeNode root) {
        if(root == null) return null;
        List<Node> l = new ArrayList<>();
        Node n = new Node(root.val, l);
        TreeNode p = root.left;
        while(p != null) {
            l.add(decode(p));
            p = p.right;
        }
        
        return n;
    }
}

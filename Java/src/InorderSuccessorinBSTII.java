    
public class InorderSuccessorinBSTII {
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    
    public Node inorderSuccessor(Node x) {
        if(x.right != null) {
            Node p = x.right;
            while(p.left != null) p = p.left;
            return p;
        }
        
        Node p = x.parent;
        while(p != null && p.left != x) {
            x = p;
            p = p.parent;
        }
        return p;
    }
    
    
}


public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    
    private Node last;
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node n = root;
        while(n.left != null) {
            n = n.left;
        }
        
        dfs(root);
        n.left = last;
        last.right = n;
        return n;
    }
    
    private void dfs(Node n) {
        if(n == null) return;
        dfs(n.left);
        n.left = last;
        if(last != null) last.right = n;
        last = n;
        dfs(n.right);
    }
}


public class QuadTreeIntersection {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node intersect(Node n1, Node n2) {
        if(n1 == null && n2 == null) return null;
        if(n1 == null && n2 != null) return n2;
        if(n1 != null && n2 == null) return n1;
        if(n1.isLeaf && n2.isLeaf) {
            n1.val = n1.val || n2.val;
            return n1;
        }
        helper(n1);
        helper(n2);
        n1.topLeft = intersect(n1.topLeft, n2.topLeft);
        n1.topRight = intersect(n1.topRight, n2.topRight);
        n1.bottomLeft = intersect(n1.bottomLeft, n2.bottomLeft);
        n1.bottomRight = intersect(n1.bottomRight, n2.bottomRight);
        if(n1.topRight.isLeaf
                && n1.bottomLeft.isLeaf
                && n1.bottomRight.isLeaf
                && n1.topLeft.isLeaf
                && n1.topLeft.val == n1.topRight.val 
                && n1.topLeft.val == n1.bottomLeft.val
                && n1.topLeft.val == n1.bottomRight.val) {
            n1.isLeaf = true;
            n1.val = n1.topLeft.val;
            n1.bottomLeft = null;
            n1.bottomRight = null;
            n1.topLeft = null;
            n1.topRight = null;
        }
        else n1.isLeaf = false;
            
        return n1;
    }
    
    private void helper(Node n) {
        if(n.isLeaf) {
            n.topLeft = new Node(n.val, true, null, null, null, null);
            n.topRight = new Node(n.val, true, null, null, null, null);
            n.bottomLeft = new Node(n.val, true, null, null, null, null);
            n.bottomRight = new Node(n.val, true, null, null, null, null);
        }
    }
}

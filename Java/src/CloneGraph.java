import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;
    
        public Node() {}
    
        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private HashMap<Integer, Node> set;
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        set = new HashMap<Integer, Node>();
        return cloneGraphHelper(node);
    }
    
    private Node cloneGraphHelper(Node node) {
        if(set.containsKey(node.val)) return set.get(node.val);

        Node copy = new Node(node.val, new ArrayList<>());
        set.put(node.val, copy);
        for(Node n : node.neighbors) {
            copy.neighbors.add(cloneGraphHelper(n));
        }
        
        return copy;
    }

}

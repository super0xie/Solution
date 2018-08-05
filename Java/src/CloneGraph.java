import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph {
    
    HashMap<Integer, UndirectedGraphNode> set;
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        set = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphHelper(node);
    }
    
    private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node) {
        if(set.containsKey(node.label)) return set.get(node.label);

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        set.put(node.label, copy);
        for(UndirectedGraphNode n : node.neighbors) {
            copy.neighbors.add(cloneGraphHelper(n));
        }
        
        return copy;

    }

}

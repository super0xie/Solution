import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeNaryTree {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	
	// Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(root);
        sb.append(root.val);
        
        while(!queue.isEmpty()) {
        	sb.append("/");
        	ArrayList<Node> aux = new ArrayList<Node>();
        	for(int i = 0; i < queue.size(); i++) {
        		for(Node n : queue.get(i).children) {
        			aux.add(n);
        			sb.append(n.val + " " + i + " ");
        		}
        	}
        	queue = aux;
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        String[] rows = data.split("/");
        
        ArrayList<Node> pre = new ArrayList<>();
        Node root = new Node(Integer.parseInt(rows[0]), new ArrayList<Node>());
        pre.add(root);
        for(int i = 1; i < rows.length; i++) {
        	String[] r = rows[i].split(" ");
        	ArrayList<Node> aux = new ArrayList<>();
        	for(int j = 0; j < r.length; j=j+2) {
        		Node n = new Node(Integer.parseInt(r[j]), new ArrayList<Node>());
        		int idx = Integer.parseInt(r[j+1]);
        		pre.get(idx).children.add(n);
        		aux.add(n);
        	}
        	pre = aux;
        }
        return root;
    }
    
    public static void main(String[] args) {
    	SerializeandDeserializeNaryTree test = new SerializeandDeserializeNaryTree();
    	String data = "1/3 0 2 0 4 0 /5 0 6 0 /";
    	Node r = test.deserialize(data);
    	String ser = test.serialize(r);
    	System.out.println(ser);
    }
}

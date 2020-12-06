import java.util.HashMap;

public class CloneBinaryTreeWithRandomPointer {
	
	
	public class Node {
	    int val;
	    Node left;
	    Node right;
	    Node random;
	    Node() {}
	    Node(int val) { this.val = val; }
	    Node(int val, Node left, Node right, Node random) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	        this.random = random;
	    }
	}
	
	public class NodeCopy {
	    int val;
	    NodeCopy left;
	    NodeCopy right;
	    NodeCopy random;
	    NodeCopy() {}
	    NodeCopy(int val) { this.val = val; }
	    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	        this.random = random;
	    }
	}
	
	private HashMap<Node, NodeCopy> map = new HashMap<>();
	public NodeCopy copyRandomBinaryTree(Node root) {
		NodeCopy res = dfs1(root);
		dfs2(res, root);
		return res;
    }
	
	private NodeCopy dfs1(Node root) {
		if(root == null) return null;
        NodeCopy n = new NodeCopy(root.val);
        map.put(root, n);
        n.left = dfs1(root.left);
        n.right = dfs1(root.right);
        return n;
	}
	
	private void dfs2(NodeCopy root, Node node) {
		if(root == null) return;
		root.random = map.get(node.random);
		dfs2(root.left, node.left);
		dfs2(root.right, node.right);
	}
	
	
	
}


public class FlattenaMultilevelDoublyLinkedList {
	
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;

	    public Node() {}

	    public Node(int _val,Node _prev,Node _next,Node _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
	};
	
	private Node p;
	
	public Node flatten(Node head) {
		if(head == null) return null;
        p = new Node();
        dfs(head);
        head.prev = null;
        return head;
    }
	
	private void dfs(Node n) {
		while(n != null) {
			p.next = n;
			n.prev = p;
			p = n;
			Node next = n.next;
			if(n.child != null) {
				dfs(n.child);
			}
			n.child = null;
			n = next;
		}
	}
	
	public static void main(String[] args) {
		FlattenaMultilevelDoublyLinkedList test = new FlattenaMultilevelDoublyLinkedList();
		Node n1 = test.new Node(1, null, null, null);
		Node n2 = test.new Node(2, null, null, null);
		Node n3 = test.new Node(3, null, null, null);
		Node n4 = test.new Node(4, null, null, null);
		Node n5 = test.new Node(5, null, null, null);
		n1.next = n2;
		n2.next = n3;
		n2.prev = n1;
		n3.prev = n2;
		n4.next = n5;
		n5.prev = n4;
		n2.child = n4;
		test.flatten(n1);
	}
}

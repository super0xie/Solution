
public class InsertintoaCyclicSortedList {
	
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _next) {
	        val = _val;
	        next = _next;
	    }
	};
	
	public Node insert(Node head, int insertVal) {
		
		if(head == null) {
			Node ret = new Node();
			ret.val = insertVal;
			ret.next = ret;
			return ret;
		}
		
        //find the max that smaller than insertVal and keep track of the max
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		Node n1 = null;
		Node n2 = null;
		
		Node p = head;
		
		do {
			if(p.val < insertVal && p.val >= max1) {
				max1 = p.val;
				n1 = p;
			}
			
			if(p.val >= max2) {
				max2 = p.val;
				n2 = p;
			}
			
			p = p.next;
		}while(p != head);
		
		Node n = null;
		if(n1 != null) {
			//insert after n1
			n = n1;
		}else {
			//insert after n2
			n = n2;
		}
		
		Node toInsert = new Node();
		toInsert.val = insertVal;
		toInsert.next = n.next;
		n.next = toInsert;
		return head;
    }
}


public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        boolean carry = helper(head);
        if(carry) {
        	ListNode n = new ListNode(1);
        	n.next = head;
        	return n;
        }else {
        	return head;
        }
        
        
    }
	
	private boolean helper(ListNode node) {
		
		boolean carry = false;
		if(node.next == null) carry = true;
		else carry = helper(node.next);
		
		if(carry) node.val++;
		if(node.val == 10) {
			node.val = 0;
			return true;
		}else {
			return false;
		}
	}
}

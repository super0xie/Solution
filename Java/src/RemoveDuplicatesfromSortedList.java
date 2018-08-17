
public class RemoveDuplicatesfromSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode n = head;
		if(head == null) return head;
        while(n.next != null) {
        	if(n.val == n.next.val) {
        		n.next = n.next.next;
        	}else {
        		n = n.next;
        	}
        }
        	
        return head;
    }

}

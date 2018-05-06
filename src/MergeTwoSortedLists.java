
public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
        while(l1 != null || l2 != null) {
        	if(l1 != null && l2 != null) {
        		if(l1.val < l2.val) {
        			tail.next = l1;
        			l1 = l1.next;
        			tail = tail.next;
        		}else {
        			tail.next = l2;
        			l2 = l2.next;
        			tail = tail.next;
        		}
        	}else if(l2 == null) {
        		tail.next = l1;
    			l1 = l1.next;
    			tail = tail.next;
        	}else {
        		tail.next = l2;
    			l2 = l2.next;
    			tail = tail.next;
        	}
        }
        
        ListNode result = head.next;
        head.next = null;
        return result;
    }

}

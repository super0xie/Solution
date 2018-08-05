
public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(true) {
        	fast = fast.next;
        	if(fast == null) return false;
        	fast = fast.next;
        	slow = slow.next;
        	
        	if(fast == null || slow == null) return false;
        	
        	if(fast == slow) return true;
        	
        }
        
    }

}

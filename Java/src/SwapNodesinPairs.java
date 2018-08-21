
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode savedHead = head.next;
    	ListNode p = head;
    	ListNode previous = null;
    	
    	while(p != null && p.next != null) {
    		ListNode next = p.next;
    		if(previous != null)
    			previous.next = next;
    		p.next = p.next.next;
    		next.next = p;
    		previous = p;
    		p = p.next;
    	}
    	
    	return savedHead;  
    }

}

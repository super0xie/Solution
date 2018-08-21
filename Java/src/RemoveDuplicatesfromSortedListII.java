
public class RemoveDuplicatesfromSortedListII {
	
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode resultHead = null;
    	ListNode p = head;
    	ListNode pre = null;
    	
    	while(p != null) {
    		if(p.next == null || p.val != p.next.val) {
    			if(resultHead == null)
    				resultHead = p;
    			pre = p;
    			p = p.next;
    		}else {
    			ListNode tail = p;
    			while(tail.next != null && tail.next.val == p.val) {
    				tail = tail.next;
    			}
    			if(pre != null)
    				pre.next = tail.next;
    			p = tail.next;
    		}
    		
    	}
    	
    	
    	return resultHead;
        
    }
    
}

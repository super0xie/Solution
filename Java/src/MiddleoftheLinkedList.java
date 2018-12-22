
public class MiddleoftheLinkedList {
	public ListNode middleNode2Round(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null) {
        	count++;
        	p = p.next;
        }
        
        int idx = 0;
        p = head;
        
        while(idx != count / 2) {
        	p = p.next;
        	idx++;
        }
        return p;
    }
	
	public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        
        while(f != null && f.next != null) {
        	s = s.next;
        	f = f.next.next;
        }
        return s;
    }
}

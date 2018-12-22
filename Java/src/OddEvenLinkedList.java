
public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null) return head;
		ListNode odd = head;
		ListNode even = head.next;
		
		ListNode p = odd;
		ListNode q = even;
		
		while(p != null && p.next != null && q != null && q.next != null) {
			p.next = p.next.next;
			p = p.next;
			q.next = q.next.next;
			q = q.next;
		}
		
		p.next = even;
		return head;
    }
	
}

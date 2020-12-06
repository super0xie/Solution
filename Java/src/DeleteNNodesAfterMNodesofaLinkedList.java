
public class DeleteNNodesAfterMNodesofaLinkedList {
	
	public ListNode deleteNodes(ListNode head, int m, int n) {
		ListNode p = head;
		while(p != null) {
			ListNode aux = p;
			for(int i = 0; i < m-1; i++) {
				if(aux == null) break;
				aux = aux.next;
			}
			
			if(aux == null) break;
			
			ListNode next = aux.next;
			for(int i = 0; i < n; i++) {
				if(next == null) break;
				next = next.next;
			}
			
			aux.next = next;
			p = next;
		}
		
		return head;
    }
	
}

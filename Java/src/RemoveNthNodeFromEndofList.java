
public class RemoveNthNodeFromEndofList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int counter = 0;
        while(node != null) {
        	node = node.next;
        	counter++;
        }
        
        int index = counter - n;
        if(index == 0) return head.next;
        
        node = head;
        for(int i = 0; i < index - 1; i++) {
        	node = node.next;
        }
        
        node.next = node.next.next;
        
        return head;
        
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
		ListNode head = test.removeNthFromEnd(n1, 2);
		
		System.out.println("hello");
		
	}

}

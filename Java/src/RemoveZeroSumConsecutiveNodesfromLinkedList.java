import java.util.HashMap;

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
	
	public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map1 = new HashMap<>();
        HashMap<ListNode, Integer> map2 = new HashMap<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        map1.put(0, dummy);
        map2.put(dummy, 0);
        
        int sum = 0;
        while(p != null) {
        	sum += p.val;
        	if(!map1.containsKey(sum)) {
        		map1.put(sum, p);
        		map2.put(p, sum);
        		p = p.next;
        	} else {
        		ListNode h = map1.get(sum);
        		ListNode cur = h.next;
        		h.next = p.next;
        		
        		while(cur != p) {
        			int s = map2.get(cur);
        			map1.remove(s);
        			map2.remove(cur);
        			cur = cur.next;
        		}
        		
        		p = h.next;
        	}
        }
        
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(-3);
		ListNode n5 = new ListNode(-2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		RemoveZeroSumConsecutiveNodesfromLinkedList test = new RemoveZeroSumConsecutiveNodesfromLinkedList();
		ListNode head = test.removeZeroSumSublists(n1);
		
		while(head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		
	}
	
}

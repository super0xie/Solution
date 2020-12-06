
public class MergeInBetweenLinkedLists {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = null;
		if(a == 0) res = list2;
		else res = list1;
		
		int i = 0;
		ListNode p = list1;
		ListNode p1 = null;
		ListNode p2 = null;
		
		while(i <= b) {
			if(i == a-1) p1 = p;
			if(i == b) p2 = p;
			p = p.next;
			i++;
		}
		
		if(p1 != null) p1.next = list2;
		
		p = list2;
		while(p != null && p.next != null) p = p.next;
		
		p.next = p2.next;
		p2.next = null;
		return res;
    }
}

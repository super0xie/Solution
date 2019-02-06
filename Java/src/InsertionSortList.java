
public class InsertionSortList {
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        
        ListNode sortedHead = head;
        ListNode h = head.next;
        head.next = null;
        
        while(h != null) {
            ListNode n = h;
            h = h.next;
            
            if(n.val < sortedHead.val) {
                n.next = sortedHead;
                sortedHead = n;
            }else {
                ListNode p = sortedHead;
                while(p != null) {
                    if(p.val <= n.val && (p.next == null || n.val <= p.next.val)) {
                        n.next = p.next;
                        p.next = n;
                        break;
                    }else {
                        p = p.next;
                    }
                }
            }
        }
        
        return sortedHead;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        
        InsertionSortList test = new InsertionSortList();
        test.insertionSortList(n1);
    }
    
}

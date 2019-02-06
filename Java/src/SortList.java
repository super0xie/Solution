
public class SortList {
    
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode f = head;
        ListNode s = head;
        ListNode sPre = head;
        
        while(f != null && f.next != null) {
            f = f.next.next;
            sPre = s;
            s = s.next;
        }
        
        ListNode lh = head;
        ListNode rh = s;
        sPre.next = null;
        
        ListNode l = sortList(lh);
        ListNode r = sortList(rh);
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while(l != null || r != null) {
            if(l != null && r != null) {
                if(l.val <= r.val) {
                    p.next = l;
                    l = l.next;
                }else {
                    p.next = r;
                    r = r.next;
                }
                p = p.next;
            }else if(l != null) {
                p.next = l;
                l = l.next;
                p = p.next;
            }else if(r != null) {
                p.next = r;
                r = r.next;
                p = p.next;
            }
        }
        
        return dummy.next;
    }
}

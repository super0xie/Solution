import java.util.ArrayList;

public class ReorderList {
    
    public void reorderListONSpace(ListNode head) {
        ListNode p = head;
        ArrayList<ListNode> l = new ArrayList<>();
        
        while(p != null) {
            l.add(p);
            p = p.next;
        }
        
        int i = 0;
        int j = l.size()-1;
        ListNode dummy = new ListNode(0);
        p = dummy;
        while(i <= j) {
            p.next = l.get(i++);
            p = p.next;
            if(j > i) {
                p.next = l.get(j--);
                p = p.next;
            }
        }
        p.next = null;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode f = head;
        ListNode s = head;
        ListNode pre = null;
        
        while(f != null && f.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        if(pre != null) pre.next = null;
        ListNode h1 = head;
        ListNode h2 = reverseList(s);
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(h1 != null) {
            p.next = h1;
            h1 = h1.next;
            p = p.next;
            
            if(h2 != null) {
                p.next = h2;
                h2 = h2.next;
                p = p.next;
            }
        }
        
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q;
        ListNode aux;
        if(head != null) {
            q = head.next;
            head.next = null;
        }
        else
            return null;
        
        while(q != null) {
            aux = q.next;
            q.next = p;
            p = q;
            q = aux;
        }
        
        return p;
 
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ReorderList test = new ReorderList();
        test.reorderList(n1);
    }
    
    
    
}

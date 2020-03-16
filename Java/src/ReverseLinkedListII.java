

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int idx = 1;
        ListNode p = head;
        ListNode dummy = new ListNode(0);

        ListNode subtail = null;
        ListNode firstTail = null;

        while(p != null){
            ListNode next = p.next;
            if(idx == m-1) firstTail = p;
            if(idx >= m && idx <= n){
                p.next = dummy.next;
                dummy.next = p;
                if(idx == m) subtail = p;
                if(idx == n && firstTail != null) firstTail.next = dummy.next;
            }
            if(idx == n+1) {
                subtail.next = p;
                break;
            }
            p = next;
            idx++;
        }

        if(m == 1) return dummy.next;
        else return head;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        ReverseLinkedListII test = new ReverseLinkedListII();
        ListNode h = test.reverseBetween(n0, 0, 2);
        System.out.print("test");
    }
}
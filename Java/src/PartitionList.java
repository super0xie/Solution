
public class PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0);
        ListNode dummyR = new ListNode(0);
        ListNode pL = dummyL;
        ListNode pR = dummyR;
        
        while(head != null) {
            if(head.val < x) {
                pL.next = head;
                head = head.next;
                pL = pL.next;
            }else {
                pR.next = head;
                head = head.next;
                pR = pR.next;
            }
        }
        pR.next = null;
        
        if(pL == dummyL) {
            return dummyR.next;
        }else {
            pL.next = dummyR.next;
            return dummyL.next;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}

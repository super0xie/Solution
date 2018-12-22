import java.util.ArrayList;

public class AddTwoNumbersII {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        
        ListNode p = l1;
        while(p != null) {
            a1.add(p.val);
            p = p.next;
        }
        p = l2;
        while(p != null) {
            a2.add(p.val);
            p = p.next;
        }
        int carry = 0;
        int i = a1.size()-1;
        int j = a2.size()-1;
        
        ArrayList<Integer> res = new ArrayList<>();
        ListNode head = null;
        
        while(i >= 0 || j >= 0) {
            int r = 0;
        
            if(i >= 0 && j >= 0) r = a1.get(i--) + a2.get(j--) + carry;
            else if(i >= 0 && j < 0) r = a1.get(i--) + carry;
            else if(i < 0 && j >= 0) r = a2.get(j--) + carry;
            if(r >= 10) {
                carry = 1;
                r = r - 10;
            }else {
                carry = 0;
            }
            
            ListNode n = new ListNode(r);
            n.next = head;
            head = n;
            
        }
        
        if(carry == 1) {
            ListNode n = new ListNode(1);
            n.next = head;
            head = n;
        }
        
        return head;
    }
    
}

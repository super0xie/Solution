
public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = null;
        ListNode head = null;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1=l1.next;
                l2=l2.next;
            }else {
                if(l1 != null) {
                    sum = carry + l1.val;
                    l1=l1.next;
                }else {
                    sum = carry + l2.val;
                    l2 = l2.next;
                }
                
            }
            
            if(sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            
            ListNode cur = new ListNode(sum);
            if(head == null) head = cur;
            if(pre != null) pre.next = cur;
            pre = cur;
        }
        
        if(carry > 0) {
            ListNode cur = new ListNode(1);
            if(pre != null) pre.next = cur;
            pre = cur;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        
        n1.next = n2;
        n2.next = n3;
        
        n4.next = n5;
        n5.next = n6;
        
        AddTwoNumbers test = new AddTwoNumbers();
        test.addTwoNumbers(n1, n4);
        
    }

}

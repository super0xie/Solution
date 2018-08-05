import java.util.ArrayList;

public class RotateList {
    
    
    
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return null;
        
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode p = head;
        while(p != null) {
            list.add(p);
            p = p.next;
        }
        
        if(list.size() == 1) return head;
        
        int lengthToRotate = k % list.size();
        if(lengthToRotate == 0) return head;
        
        list.get(list.size() - lengthToRotate - 1).next = null;
        list.get(list.size() - 1).next = list.get(0);
        
        return list.get(list.size() - lengthToRotate);
        
    }
    
    public ListNode rotateRight2(ListNode head, int k) {

        if(head == null)
            return null;
        
        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }
        
        if(length == 1) return head;
        
        int rightRotateLength = k % length;
        if(rightRotateLength == 0) return head;
        
        int leftRotateLength = length - rightRotateLength;
        
        for(int i = 0; i < leftRotateLength; i++) {
            tail.next = head;
            tail = head;
            head = head.next;
            tail.next = null;
        }

        return head;
        
    }
    
    public ListNode rotateRight3(ListNode head, int k) {

        if(head == null)
            return null;
        
        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            length++;
            tail = tail.next;
        }
        
        if(length == 1) return head;
        
        int rightRotateLength = k % length;
        if(rightRotateLength == 0) return head;
        
        int leftRotateLength = length - rightRotateLength;
        
        tail.next = head;
        for(int i = 0; i < leftRotateLength-1; i++) {
            head = head.next;
        }
        
        tail = head;
        head = head.next;
        tail.next = null;

        return head;
        
    }
    
    

}

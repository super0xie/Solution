
public class IntersectionofTwoLinkedLists {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA = 0;
        ListNode head = headA;
        while(head != null) {
            lengthA++;
            head = head.next;
        }
        
        int lengthB = 0;
        head = headB;
        while(head != null) {
            lengthB++;
            head = head.next;
        }
        
        ListNode longPointer = null;
        ListNode shortPointer = null;
        
        if(lengthA >= lengthB) {
            longPointer = headA;
            shortPointer = headB;
        }else {
            longPointer = headB;
            shortPointer = headA;
        }
        
        int counter = 0;
        
        while(counter < Math.abs(lengthA - lengthB)) {
            longPointer = longPointer.next;
            counter++;
        }
        
        
        while(longPointer != null && shortPointer != null) {
            if(longPointer == shortPointer) return longPointer;
            
            longPointer = longPointer.next;
            shortPointer = shortPointer.next;
        }
        
        return null;
        
    }

}

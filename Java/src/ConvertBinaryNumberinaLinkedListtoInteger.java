
public class ConvertBinaryNumberinaLinkedListtoInteger {
	
	public int getDecimalValue(ListNode head) {
        int n = 0;
        
        while(head != null) {
        	n = n << 1;
        	if(head.val == 1) n += 1;
        	head = head.next;
        }
        
        return n;
    }
}

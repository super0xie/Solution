import java.util.Random;

public class LinkedListRandomNode {
    private ListNode head;
    public void Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode p = head.next;
        int count = 1;
        int res = head.val;
        Random r = new Random();
        
        while(p != null) {
            count++;
            int ran = r.nextInt(count);
            if(ran == count-1) res = p.val;
            p = p.next;
        }
        
        return res;
    }
}

import java.util.ArrayList;

public class PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();
        ListNode p = head;
        while(p != null) {
            l.add(p.val);
            p = p.next;
        }
        
        int i = 0;
        int j = l.size()-1;
        
        while(i <= j) {
            if(!l.get(i).equals(l.get(j))) return false;
            i++;
            j--;
        }
        
        return true;
    }
}

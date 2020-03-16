import java.util.ArrayList;

public class ReverseNodesinkGroup {

    public ListNode reverseKGroupMLE(ListNode head, int k) {
        if(head == null) return null;
        ArrayList<ListNode> l = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            l.add(p);
            p = p.next;
        }

        ListNode[] arr = new ListNode[l.size()];
        int idx = 0;

        for(int i = 0; i < l.size(); i++){
            if(l.size() - i >= k){
                int j = i + k - 1;
                while(j >= i){
                    arr[idx++] = l.get(j);
                    j--;
                }
                i = i + k - 1;
            }else{
                while(i < l.size()){
                    arr[idx++] = l.get(i);
                    i++;
                }
            }
        }
        for(int i = 0; i < arr.length-1; i++){
            arr[i].next = arr[i+1];
        }
        return arr[0];
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while(p != null){
            ListNode q = p;
            int count = 1;
            while(q != null){
                q = q.next;
                count++;
                if(count == k) break;
            }

            if(q != null){
                ListNode next = q.next;
                q.next = null;
                tail.next = reverseList(p);
                tail = p;
                p = next;
            }else{
                tail.next = p;
                break;
            }
        }

        return dummy.next;
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

}
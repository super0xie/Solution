import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodesOld(ListNode head) {
        int len = 0;
        ListNode n = head;
        while(n != null){
            len++;
            n = n.next;
        }

        int[] res = new int[len];
        Stack<Integer> values = new Stack<>();
        Stack<Integer> indice = new Stack<>();

        n = head;
        int cur = 0;
        while(n != null){
            while(!values.isEmpty() && values.peek() < n.val){
                int idx = indice.pop();
                values.pop();
                res[idx] = n.val;
            }

            indice.push(cur);
            values.push(n.val);

            n = n.next;
            cur++;
        }

        return res;
    }

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> values = new Stack<>();
        Stack<Integer> indice = new Stack<>();

        ListNode n = head;
        int cur = 0;
        while(n != null){
            while(!values.isEmpty() && values.peek() < n.val){
                int idx = indice.pop();
                values.pop();
                res.set(idx, n.val);
            }
            res.add(0);
            indice.push(cur);
            values.push(n.val);

            n = n.next;
            cur++;
        }

        int[] ret = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }

        return ret;
    }

}
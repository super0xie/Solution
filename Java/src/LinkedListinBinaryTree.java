import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListinBinaryTree {
    
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode p = head;
        ArrayList<Integer> l = new ArrayList<>();
        while(p != null) {
            l.add(p.val);
            p = p.next;
        }
        return dfs(root, new LinkedList<>(), l);
    }
    
    private boolean dfs(TreeNode n, LinkedList<Integer> l, ArrayList<Integer> p) {
        if(n == null) return false;
        l.addFirst(n.val);
        
        if(helper(l, p)) return true;
        
        boolean res = false;
        res = res || dfs(n.left, l, p);
        res = res || dfs(n.right, l, p);
        
        l.removeFirst();
        return res;
    }
    
    private boolean helper(LinkedList<Integer> l, ArrayList<Integer> p) {
        if(l.size() < p.size()) return false;
        int idx = p.size()-1;
        for(int i : l) {
            if(i != p.get(idx)) return false;
            idx--;
            if(idx < 0) return true;
        }
        return false;
    }
    
    
}

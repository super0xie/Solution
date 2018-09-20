
public class ConvertSortedListtoBinarySearchTree {
    
    ListNode cur;
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int count = 0;
        while(p != null) {
            count++;
            p = p.next;
        }
        
        cur = head;
        
        return build(0, count-1);
        
    }
    
    private TreeNode build(int start, int end) {
        if(start > end) return null;
        if(start == end) {
            TreeNode ret = new TreeNode(cur.val);
            cur = cur.next;
            return ret;
        }
        
        
        int mid = start + (end-start) / 2;
        
        TreeNode l = build(start, mid-1);
        TreeNode ret = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode r = build(mid+1, end);
        
        ret.left = l;
        ret.right = r;
        
        return ret;
    }
    
    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree test = new ConvertSortedListtoBinarySearchTree();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        test.sortedListToBST(n1);
    }

}

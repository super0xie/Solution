import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestBinarySearchTreeValueII {
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> l = new ArrayList<>();
        helper(root, l);

        List<Integer> res = new ArrayList<>();
        int bs = Collections.binarySearch(l, (int)target);
        int i, j;

        if(bs < 0) {
            bs = -bs-1;
            i = bs-1;
            j = bs;
        }else{
            i = bs;
            j = bs + 1;
        }

        while(res.size() < k){
            if(i >= 0 && i < l.size() && j >= 0 && j < l.size()){
                if(Math.abs(l.get(i)-target) < Math.abs(l.get(j)-target)){
                    res.add(l.get(i--));
                }else{
                    res.add(l.get(j++));
                }
            }else if(i >= 0 && i < l.size()){
                res.add(l.get(i--));
            }else if(j >= 0 && j < l.size()){
                res.add(l.get(j++));
            }
        }

        return res;
    }

    private void helper(TreeNode n, List<Integer> l){
        if(n == null) return;
        helper(n.left, l);
        l.add(n.val);
        helper(n.right, l);
        return;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        ClosestBinarySearchTreeValueII test = new ClosestBinarySearchTreeValueII();
        test.closestKValues(n1, 4.4, 1);
    }
}

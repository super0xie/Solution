import java.util.ArrayList;

public class RecoverBinarySearchTree {
    
    private int cur = 0;
    public void recoverTreeOld(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        dfs(root, l);
        int idxLTN = -1;
        int idxSTP = -1;

        for(int i = 0; i < l.size(); i++){
            if(idxLTN == -1 && i != l.size()-1 && l.get(i) > l.get(i+1)) idxLTN = i;
            if(i != 0 && l.get(i) < l.get(i-1)) idxSTP = i;
        }

        int temp = l.get(idxLTN);
        l.set(idxLTN, l.get(idxSTP));
        l.set(idxSTP, temp);

        recover(root, l);
    }

    private void recover(TreeNode n, ArrayList<Integer> l){
        if(n == null) return;
        recover(n.left, l);
        n.val = l.get(cur++);
        recover(n.right, l);
    }

    private void dfs(TreeNode n, ArrayList<Integer> l){
        if(n == null) return;
        dfs(n.left, l);
        l.add(n.val);
        dfs(n.right, l);
    }

    TreeNode ltn;
    TreeNode stp;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int aux = ltn.val;
        ltn.val = stp.val;
        stp.val = aux;
    }

    private void dfs(TreeNode n){
        if(n == null) return;
        dfs(n.left);

        if(pre != null){
            if(n.val < pre.val){
                if(ltn == null) ltn = pre;
                stp = n;
            }
        }
        pre = n;

        dfs(n.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.left = n3;
        n3.right = n2;
        RecoverBinarySearchTree test = new RecoverBinarySearchTree();
        test.recoverTree(n1);
    }

}
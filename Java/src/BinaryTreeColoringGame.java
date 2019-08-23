
public class BinaryTreeColoringGame {

    private boolean res;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, n, x);
        return res;
    }

    private int dfs(TreeNode node, int n, int x){
        if(node == null) return 0;

        int left = dfs(node.left, n, x);
        int right = dfs(node.right, n, x);

        if(node.val == x){
            int up = n - left - right - 1;
            int p2 = Math.max(left, Math.max(right, up));
            int p1 = n-p2;
            if(p2 > p1) this.res = true;
            return left + right + 1;
        }else{
            return left + right + 1;
        }
    }

}
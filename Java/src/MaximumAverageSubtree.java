public class MaximumAverageSubtree{

    private double res = 0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode n){
        if(n == null) return new int [] {0, 0};

        int[] l = dfs(n.left);
        int[] r = dfs(n.right);

        int sum = l[0] + r[0] + n.val;
        int count = l[1] + r[1] + 1;

        res = Math.max(res, (double)sum/count);
        return new int[] {sum, count};
    }

}
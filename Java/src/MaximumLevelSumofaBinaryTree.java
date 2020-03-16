import java.util.Arrays;

public class MaximumLevelSumofaBinaryTree{

    public int maxLevelSum(TreeNode root) {
        int[] sum = new int[1000];
        Arrays.fill(sum, Integer.MAX_VALUE);
        helper(root, 0, sum);
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0; i < sum.length; i++){
            if(sum[i] == Integer.MAX_VALUE) break;

            if(sum[i] > max){
                max = sum[i];
                res = i+1;
            }
        }
        return res;
    }

    private void helper(TreeNode n, int depth, int[] sum){
        if(n == null) return;
        if(sum[depth] == Integer.MAX_VALUE) sum[depth] = 0;
        sum[depth] += n.val;
        helper(n.left, depth+1, sum);
        helper(n.right, depth+1, sum);
    }

}
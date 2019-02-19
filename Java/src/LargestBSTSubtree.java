public class LargestBSTSubtree{


    private int maxCount = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxCount;
    }

    //int[3] min, max, count
    private int[] helperOld(TreeNode n){
        if(n == null) return null;

        int[] l = helper(n.left);
        int[] r = helper(n.right);

        if(l != null && r != null){
            if(n.val > l[1] && n.val < r[0]){
                int count = l[2] + r[2] + 1;
                maxCount = Math.max(maxCount, count);
                return new int[] {l[0], r[1], count};
            }
        }else if(l != null && r == null){
            if(n.val > l[1]){
                int count = l[2] + 1;
                maxCount = Math.max(maxCount, count);
                return new int[] {l[0], n.val, count};
            }
        }else if(l == null && r != null){
            if(n.val < r[0]){
                int count = r[2] + 1;
                maxCount = Math.max(maxCount, count);
                return new int[] {n.val, r[1], count};
            }
        }else if(l == null && r == null){
            maxCount = Math.max(maxCount, 1);
            return new int[] {n.val, n.val, 1};
        }

        return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, -1};
    }

    private int[] helper(TreeNode n){
        if(n == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] l = helper(n.left);
        int[] r = helper(n.right);

        if(n.val > l[1] && n.val < r[0]){
            int count = l[2] + r[2] + 1;
            maxCount = Math.max(maxCount, count);
            int min = l[0] == Integer.MAX_VALUE ? n.val : l[0];
            int max = r[1] == Integer.MIN_VALUE ? n.val : r[1];
            return new int[] {min, max, count};
        }
        return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, -1};
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n4.left = n7;
        n7.left = n8;

        LargestBSTSubtree test = new LargestBSTSubtree();
        System.out.print(test.largestBSTSubtree(n1));
    }

}
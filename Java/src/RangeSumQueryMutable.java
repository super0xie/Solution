public class RangeSumQueryMutable{
    class Node{
        int lb;
        int rb;
        Node left;
        Node right;
        int val;

        Node(int lb, int rb){
            this.lb = lb;
            this.rb = rb;
        }
    }

    Node root;

    private Node build(int[] nums, int i, int j){
        Node n = new Node(i, j);
        if(i == j) {
            n.val = nums[i];
            return n;
        } else{
            int mid = i + (j-i)/2;
            n.left = build(nums, i, mid);
            n.right = build(nums, mid+1, j);
            n.val = n.left.val + n.right.val;
            return n;
        }
    }

    public void NumArray(int[] nums) {
        if(nums.length == 0) return;
        root = build(nums, 0, nums.length-1);
    }

    private int update(Node n, int i, int val){
        if(n == null) return 0;
        if(n.lb == n.rb && n.rb == i){
            int diff = n.val - val;
            n.val = val;
            return diff;
        }

        if(n.left != null && i <= n.left.rb){
            int diff = update(n.left, i, val);
            n.val -= diff;
            return diff;
        }

        if(n.right != null && i >= n.right.lb){
            int diff = update(n.right, i, val);
            n.val -= diff;
            return diff;
        }

        return 0;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }



    private int sum(Node n, int i, int j){
        if(n == null) return 0;
        if(n.lb == i && n.rb == j) return n.val;
        else {
            if(n.left != null && j <= n.left.rb) return sum(n.left, i, j);
            if(n.right != null && i >= n.right.lb) return sum(n.right, i, j);
            return sum(n.left, i, n.left.rb) + sum(n.right, n.right.lb, j);
        }
    }
    
    public int sumRange(int i, int j) {
        return sum(root, i, j);
    }

    public static void main(String[] args) {
        RangeSumQueryMutable test = new RangeSumQueryMutable();
        int[] nums = {1,3,5};
        test.NumArray(nums);
        System.out.println(test.sumRange(0, 2));
        test.update(1, 2);
        System.out.println(test.sumRange(0, 2));
    }





}
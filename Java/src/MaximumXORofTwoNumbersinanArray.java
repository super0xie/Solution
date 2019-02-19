public class MaximumXORofTwoNumbersinanArray{

    public int findMaximumXORBF(int[] nums) {
        int res = Integer.MIN_VALUE;
        if(nums.length == 1) return 0;

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                res = Math.max(res, nums[i]^nums[j]);
            }
        }
        return res;
    }

    class Node{
        Node[] next;
        int num;

        Node(){
            next = new Node[2];
        }
    }

    private Node root;

    private void add(Node n, int idx, int[] num, int integer){
        if(idx == num.length) {
            n.num = integer;
            return;
        };
        if(n.next[num[idx]] == null) n.next[num[idx]] = new Node();
        add(n.next[num[idx]], idx+1, num, integer);
    }

    private int findMax(Node n, int idx, int[] num, int integer){
        if(idx == num.length) {
            return integer ^ n.num;
        }

        int target = num[idx] ^ 1;
        if(n.next[target] == null) target = target ^ 1;
        return findMax(n.next[target], idx+1, num, integer);
    }

    public int findMaximumXOR(int[] nums) {
        int res = Integer.MIN_VALUE;
        if(nums.length == 1) return 0;

        root = new Node();
        int[][] arr = new int [nums.length][32];

        for(int i = 0; i < nums.length; i++){
            int n = 0x80000000;
            int idx = 0;
            while(n != 0){
                arr[i][idx] = (nums[i] & n) > 0 ? 1 : 0;
                idx++;
                n = n >>> 1;
            }
            add(root, 0, arr[i], nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            res = Math.max(findMax(root, 0, arr[i], nums[i]), res);
        }
        return res;
        
    }

    public static void main(String[] args) {
        MaximumXORofTwoNumbersinanArray test = new MaximumXORofTwoNumbersinanArray();
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(test.findMaximumXOR(nums));
    }
}
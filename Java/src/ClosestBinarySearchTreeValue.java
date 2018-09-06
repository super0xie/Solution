
public class ClosestBinarySearchTreeValue {
    
    double diff = Double.MAX_VALUE;
    int res;
    
    public int closestValue(TreeNode root, double target) {
        if(root == null) return -1;
        if(Math.abs(root.val - target) < diff) {
            res = root.val;
            diff = Math.abs(root.val - target);
        }
        closestValue(root.left, target);
        closestValue(root.right, target);
        return res;
        
    }

}

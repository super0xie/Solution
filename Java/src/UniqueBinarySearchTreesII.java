import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int l, int r){
        List<TreeNode> res = new ArrayList<>();
        
        if(l > r) {
            res.add(new TreeNode(0));
            return res;
        } else if(l == r) {
            res.add(new TreeNode(l));
            return res;
        } else {
            for(int i = l; i <= r; i++) {
                
                List<TreeNode> subLeft = helper(l, i-1);
                List<TreeNode> subRight = helper(i+1, r);
                
                for(int j = 0; j < subLeft.size(); j++) {
                    for(int k = 0; k < subRight.size(); k++) {
                        TreeNode root = new TreeNode(i);
                        if(subLeft.get(j).val != 0) {
                            root.left = subLeft.get(j);
                        }
                        
                        if(subRight.get(k).val != 0) {
                            root.right = subRight.get(k);
                        }
                        
                        res.add(root);
                        
                    }
                }
            }
            
            return res;
        }
    }
    
    public static void main(String[] args) {
        UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
        List<TreeNode> res = test.generateTrees(3);
        SerializeAndDeserializeBinaryTree printer = new SerializeAndDeserializeBinaryTree();
        for(TreeNode n : res) {
            System.out.println(printer.serialize(n));
        }
    }
    
}

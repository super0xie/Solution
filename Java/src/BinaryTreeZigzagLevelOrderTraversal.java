import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean leftToRight = true;
        
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if(root != null)
            list.add(root);
        
        while(!list.isEmpty()) {
            List<Integer> resultList = new ArrayList<Integer>();
            LinkedList<TreeNode> helperList = new LinkedList<TreeNode>();
            
            while(!list.isEmpty()) {
                TreeNode node = null;
                if (leftToRight) {
                    node = list.removeFirst();
                    if(node.left != null)
                        helperList.add(node.left);
                    if(node.right != null)
                        helperList.add(node.right);
                }else {
                    node = list.removeLast();
                    if(node.right != null)
                        helperList.addFirst(node.right);
                    if(node.left != null)
                        helperList.addFirst(node.left);
                }
                resultList.add(node.val);
            }
            
            result.add(resultList);
            leftToRight = !leftToRight;
            list = helperList;
        }
        
        return result; 
    }
    
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        
        
        
        
        List<List<Integer>> result = test.zigzagLevelOrder(n1);
        
        System.out.println("hello");
        
    }
    
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ClosestLeafinaBinaryTree {
    
    private HashMap<TreeNode, ArrayList<TreeNode>> graph;
    private int k;
    private TreeNode startNode;
    
    
    public int findClosestLeaf(TreeNode root, int k) {
        
        if(root.val == k && root.left == null && root.right == null) return root.val;
        this.k = k;
        
        //build graph
        graph = new HashMap<TreeNode, ArrayList<TreeNode>>();
        graph.put(root, new ArrayList<TreeNode>());
        dfs(root);
        
        //bfs
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(startNode);
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if(n.left == null && n.right == null) return n.val;
            visited.add(n);
            for(TreeNode node: graph.get(n)) {
                if(!visited.contains(node)) {
                    queue.add(node);
                }
            }
        }
        
        return -1;
    }
    
    private void dfs(TreeNode node) {
        if(node == null) return;
        if(node.val == k) startNode = node;
        
        if(node.left != null) {
            graph.put(node.left, new ArrayList<TreeNode>());
            graph.get(node).add(node.left);
            graph.get(node.left).add(node);
            dfs(node.left);
        }
            
        if(node.right != null) {
            graph.put(node.right, new ArrayList<TreeNode>());
            graph.get(node).add(node.right);
            graph.get(node.right).add(node);
            dfs(node.right);
        }
        
    }
    

}

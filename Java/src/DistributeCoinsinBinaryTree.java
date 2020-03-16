import java.util.HashSet;
import java.util.LinkedList;

public class DistributeCoinsinBinaryTree {
	
	class Node{
		int v;
		Node [] nei;
		Node(int v){
			this.v = v;
			this.nei = new Node[3];
		}
		
		
	}
	
//	private int res = 0;
	public int distributeCoinsBad(TreeNode root) {
		Node r = build(root);
		
		helper(r);
		
		return res;
    }
	
	private void helper(Node n) {
		if(n == null) return;
		helper(n.nei[1]);
		
		if(n.v == 0) {
			int dis = 1;
			
			LinkedList<Node> q = new LinkedList<Node>();
			for(Node nei : n.nei) {
				if(nei != null) q.add(nei);
			}
			HashSet<Node> visited = new HashSet<>();
			visited.add(n);
			boolean found = false;
			while(!q.isEmpty()) {
				if(found) break;
				LinkedList<Node> aux = new LinkedList<Node>();
				
				while(!q.isEmpty()) {
					Node polled = q.poll();
					visited.add(polled);
					if(polled.v > 1) {
						res += dis;
						polled.v--;
						n.v = 1;
						found = true;
						break;
					}
					
					for(Node nei : polled.nei) {
						if(nei != null && !visited.contains(nei)) {
							aux.add(nei);
						}
					}
				}
				
				q = aux;
				dis++;
			}
			
		}
		
		
		helper(n.nei[2]);
	}
	
	private Node build(TreeNode n) {
		if(n == null) return null;
		Node node = new Node(n.val);
		Node l = build(n.left);
		Node r = build(n.right);
		
		node.nei[1] = l;
		node.nei[2] = r;
		if(l != null) l.nei[0] = node;
		if(r != null) r.nei[0] = node;
		
		return node;
	}
	
	
	
	private int res = 0;
	public int distributeCoins(TreeNode n) {
		
		helper(n);
		return res;
    }
	
	private int helper(TreeNode n) {
		if(n == null) return 0;
		
		int l = helper(n.left);
		int r = helper(n.right);
		
		int ret = l + r + n.val - 1;
		
		res += Math.abs(ret);
		return ret;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		DistributeCoinsinBinaryTree test = new DistributeCoinsinBinaryTree();
		System.out.println(test.distributeCoins(n1));
	}
}

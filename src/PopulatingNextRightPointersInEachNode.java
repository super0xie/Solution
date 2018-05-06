import java.util.LinkedList;


public class PopulatingNextRightPointersInEachNode {
	
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		LinkedList<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
		LinkedList<TreeLinkNode> q2;
		q1.add(root);
		
		while(!q1.isEmpty()) {
			q2 = new LinkedList<TreeLinkNode>();
			TreeLinkNode tail = q1.remove();
			if(tail.left != null) q2.add(tail.left);
			if(tail.right != null) q2.add(tail.right);
			
			while(!q1.isEmpty()) {
				tail.next = q1.remove();
				tail = tail.next;
				if(tail.left != null) q2.add(tail.left);
				if(tail.right != null) q2.add(tail.right);
			}
			
			tail.next = null;
			q1 = q2;
		}

    }
	
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		TreeLinkNode n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		test.connect(n1);
		
		System.out.println("ok");
	}

}


public class SegmentTree {
	
	class Node{
		int l;
		int r;
		Node left = null;
		Node right = null;
		int val;
		
		Node(int l, int r, int val){
			this.l = l;
			this.r = r;
			this.val = val;
		}
	}
	
	private Node root;
	
	SegmentTree(int n){
		this.root = buildTree(0, n-1);
	}
	
	private Node buildTree(int l, int r) {
		if(l == r) {
			return new Node(l, r, 0);
		}else {
			int mid = l + (r-l)/2;
			Node n = new Node(l, r, 0);
			n.left = buildTree(l, mid);
			n.right = buildTree(mid+1, r);
			return n;
		}
	}
	
	public void modify(int idx, int val) {
		modifyHelper(root, idx, val);
	}
	
	private void modifyHelper(Node n, int idx, int val) {
		n.val += val;
		if(n.l == n.r) return;
		if(idx <= n.left.r) modifyHelper(n.left, idx, val);
		else modifyHelper(n.right, idx, val);
	}
	
	public int get(int l, int r) {
		return getHelper(root, l, r);
	}
	
	private int getHelper(Node n, int l, int r) {
		if(n.l == l && n.r == r) return n.val;
		if(l >= n.right.l) return getHelper(n.right, l, r);
		if(r <= n.left.r) return getHelper(n.left, l, r);
		else {
			return getHelper(n.left, l, n.left.r) + getHelper(n.right, n.right.l, r);
		}
	}
	
	
	
}

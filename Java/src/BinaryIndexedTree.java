
public class BinaryIndexedTree {
	private int[] arr = null;
	private int n = 0;
	BinaryIndexedTree(int n){
		this.n = n;
		arr = new int[4*n];
	}
	
	public int get(int l, int r) {
		return getHelper(1, 0, n-1, l, r);
	}
	
	private int getHelper(int idx, int cl, int cr, int l, int r) {
		if(cl == l && cr == r) return arr[idx];
		int lr = cl + (cr-cl)/2;
		int rl = lr+1;
		if(r <= lr) {
			return getHelper(2*idx, cl, lr, l, r);
		}else if(l >= rl){
			return getHelper(2*idx+1, rl, cr, l, r);
		}else {
			return getHelper(2*idx, cl, lr, l, lr) + getHelper(2*idx+1, rl, cr, rl, r);
		}
	}
	
	public void modify(int idx, int v) {
		modifyHelper(1, 0, n-1, idx, v);
	}
	
	private void modifyHelper(int idx, int cl, int cr, int i, int v) {
		arr[idx] += v;
		if(cl == cr) return;
		int lr = cl + (cr-cl)/2;
		int rl = lr+1;
		
		if(i <= lr) modifyHelper(idx*2, cl, lr, i, v);
		else modifyHelper(idx*2+1, rl, cr, i, v);
	}
	
	
}

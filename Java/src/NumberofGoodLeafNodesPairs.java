import java.util.Arrays;

public class NumberofGoodLeafNodesPairs {
	
	private int res = 0;
	
	public int countPairs(TreeNode root, int distance) {
		dfs(root, distance);
        return res;
    }
	
	private int[] dfs(TreeNode n, int dis) {
		if(n == null) return new int[] {};
		if(n.left == null && n.right == null) return new int[] {1};
			
		int[] l = dfs(n.left, dis);
		int[] r = dfs(n.right, dis);
		
		for(int i : l) {
			int tar = dis - i;
			int bs = Arrays.binarySearch(r, tar);
			int count = 0;
			if(bs < 0) {
				bs = -bs-1;
				count = bs;
			}else {
				while(bs < r.length-1 && r[bs] == r[bs+1]) bs++;
				count = bs+1;
			}
			res += count;
		}
		
		int[] ret = new int[l.length + r.length];
		int idx = 0;
		int i = 0;
		int j = 0;
		
		while(i < l.length || j < r.length) {
			if(i < l.length && j < r.length) {
				if(l[i] <= r[j]) {
					ret[idx++] = l[i++]+1;
				}else {
					ret[idx++] = r[j++]+1;
				}
			}else if(i < l.length) {
				ret[idx++] = l[i++]+1;
			}else {
				ret[idx++] = r[j++]+1;
			}
		}
		
		return ret;
	}
	
}

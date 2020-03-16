import java.util.HashSet;

public class NumberofOperationstoMakeNetworkConnected {
	public class UnionFind {
		
		int[] uf;
		
		UnionFind(int n){
			uf = new int[n];
			for(int i = 0; i < n; i++) {
				uf[i] = i;
			}
		}
		
		public int getRoot(int i) {
			if(uf[i] == i) return i;
			else {
				int r = getRoot(uf[i]);
				uf[i] = r;
				return r;
			}
		}
		
		public void union(int i, int j) {
			int r1 = getRoot(i);
			int r2 = getRoot(j);
			
			if(r1 != r2) {
				uf[r1] = r2;
			}
		}
	}
	
	public int makeConnected(int n, int[][] connections) {
		if(connections.length < n-1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int[] con : connections) {
        	uf.union(con[0], con[1]);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
        	set.add(uf.getRoot(i));
        }
        
        return set.size()-1;
    }
	
	
	
}

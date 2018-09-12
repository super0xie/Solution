
public class RedundantConnection {
	
	public int[] findRedundantConnection(int[][] edges) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < edges.length; i++) {
        	max = Math.max(max, edges[i][0]);
        	max = Math.max(max, edges[i][1]);
        }
        
        int[] uf = new int [max+1];
        for(int i = 0; i < uf.length; i++) {
        	uf[i] = i;
        }
        
        
        for(int i = 0; i < edges.length; i++) {
        	if(getRoot(uf, edges[i][0]) == getRoot(uf, edges[i][1])) return edges[i];
        	else {
        		union(uf, edges[i][0], edges[i][1]);
        	}
        }
        
        return new int [2];
        
        
    }
	
	private int getRoot(int[] uf, int i) {
		if(uf[i] == i) return i;
		else {
			int res = getRoot(uf, uf[i]);
			uf[i] = res;
			return res;
		}
	}
	
	private void union(int[] uf, int i, int j) {
		int r1 = getRoot(uf, i);
		int r2 = getRoot(uf, j);
		if(r1 != r2) {
			uf[r1] = r2;
		}
	}

}

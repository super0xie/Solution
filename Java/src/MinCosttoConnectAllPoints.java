import java.util.PriorityQueue;

public class MinCosttoConnectAllPoints {
	
	private int[][] p;
	
	class Edge{
		int i;
		int j;
		int d;
		
		Edge(int ii, int jj){
			i = ii;
			j = jj;
			d = Math.abs(p[i][0]-p[j][0]) + Math.abs(p[i][1]-p[j][1]);
		}
	}
	
	public int minCostConnectPoints(int[][] points) {
        p = points;
        int n = points.length;
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->{return a.d-b.d;});
        
        for(int i = 0; i < n-1; i++) {
        	for(int j = i+1; j < n; j++) {
        		Edge e = new Edge(i, j);
        		pq.add(e);
        	}
        }
        
        int count = 0;
        int[] uf = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) uf[i] = i;
        while(count < n-1) {
        	Edge e = pq.poll();
        	int r1 = getRoot(uf, e.i);
        	int r2 = getRoot(uf, e.j);
        	if(r1 != r2) {
        		count++;
        		union(uf, e.i, e.j);
        		res += e.d;
        	}
        }
        
        return res;
    }
	
	private int getRoot(int[] uf, int i) {
		if(uf[i] == i) return i;
		int r = getRoot(uf, uf[i]);
		uf[i] = r;
		return r;
	}
	
	private void union(int[] uf, int i, int j) {
		int r1 = getRoot(uf, i);
		int r2 = getRoot(uf, j);
		if(r1 != r2) 
			uf[r1] = r2;
	}
	
}

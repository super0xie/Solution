import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree {
	
	
	private int n;
	private int w;
	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        this.n = n;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> pc = new ArrayList<>();
        res.add(c);
        res.add(pc);
        
        w = mst(edges);
        
        for(int i = 0; i < edges.length; i++) {
        	boolean[] r = mst(edges, i);
        	if(r[0]) c.add(i);
        	else if(r[1]) pc.add(i);
        }
        
        return res;
    }
	
	
	private int mst(int[][] edges) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return a[2]-b[2];});
		for(int i = 0; i < edges.length; i++) 
			pq.add(edges[i]);
		int[] uf = new int[n];
		for(int i = 0; i < uf.length; i++) uf[i] = i;
		int count = 0;
		int sum = 0;
		
		while(count < n-1) {
			if(pq.isEmpty()) break;
			int[] e = pq.poll();
			int r1 = getRoot(uf, e[0]);
			int r2 = getRoot(uf, e[1]);
			if(r1 != r2) {
				union(uf, e[0], e[1]);
				sum += e[2];
				count++;
			}
		}
		
		return sum;
	}
	
	//boolean[2] {isCritical, isPseudoCritical}
	private boolean[] mst(int[][] edges, int exclude) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{return a[2]-b[2];});
		boolean[] res = new boolean[2];
		for(int i = 0; i < edges.length; i++) {
			if(i == exclude) continue;
			pq.add(edges[i]);
		}
		
		int[] uf = new int[n];
		for(int i = 0; i < uf.length; i++) uf[i] = i;
		int count = 0;
		int sum = 0;
		while(count < n-1) {
			if(pq.isEmpty()) break;
			int[] e = pq.poll();
			int r1 = getRoot(uf, e[0]);
			int r2 = getRoot(uf, e[1]);
			if(r1 != r2) {
				union(uf, e[0], e[1]);
				sum += e[2];
				count++;
			}
		}
		
		if(count < n-1 || sum > w) return new boolean[] {true, false};
		int r = getRoot(uf, 0);
		
		for(int i = 1; i < n; i++) {
			if(getRoot(uf, i) != r) return new boolean[] {true, false};
		}
		
		
		sum = edges[exclude][2];
		uf = new int[n];
		for(int i = 0; i < uf.length; i++) uf[i] = i;
		union(uf, edges[exclude][0], edges[exclude][1]);
		count = 1;
		pq = new PriorityQueue<>((a, b)->{return a[2]-b[2];});
		for(int i = 0; i < edges.length; i++) {
			if(i == exclude) continue;
			pq.add(edges[i]);
		}
		while(count < n-1) {
			if(pq.isEmpty()) break;
			int[] e = pq.poll();
			int r1 = getRoot(uf, e[0]);
			int r2 = getRoot(uf, e[1]);
			if(r1 != r2) {
				union(uf, e[0], e[1]);
				sum += e[2];
				count++;
			}
		}
		
		if(sum == w) return new boolean[] {false, true};
		return new boolean[] {false, false};
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
		if(r1 != r2) uf[r1] = r2;
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0,1,1},{1,2,1},{2,3,1},{0,3,1}};
		int n = 4;
		FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree test = new FindCriticalandPseudoCriticalEdgesinMinimumSpanningTree();
		test.findCriticalAndPseudoCriticalEdges(n, edges);
	}
	
}

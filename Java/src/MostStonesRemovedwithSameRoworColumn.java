import java.util.ArrayList;
import java.util.HashMap;

public class MostStonesRemovedwithSameRoworColumn {
	
	class Node{
		int r;
		int c;
		Node p;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public int removeStones(int[][] stones) {
		ArrayList<Node> list = new ArrayList<>();
		HashMap<Integer, Node> row = new HashMap<>();
		HashMap<Integer, Node> col = new HashMap<>();
		
		for(int[] s : stones) {
			Node n = new Node(s[0], s[1]);
			list.add(n);
			if(row.containsKey(s[0])) {
				union(n, row.get(s[0]));
			}else {
				row.put(s[0], n);
			}
			
			if(col.containsKey(s[1])) {
				union(n, col.get(s[1]));
			}else {
				col.put(s[1], n);
			}
		}
		HashMap<Node, Integer> map = new HashMap<>();
		for(Node n : list) {
			Node r = getRoot(n);
			map.put(r, map.getOrDefault(r, 0)+1);
		}
		int res = 0;
		for(Node n : map.keySet()) {
			int c = map.get(n);
			if(c > 1) res += c-1;
		}
		return res;
		
	}
	
	private Node getRoot(Node n) {
		if(n.p == null) return n;
		else {
			Node r = getRoot(n.p);
			n.p = r;
			return r;
		}
	}
	
	private void union(Node n1, Node n2) {
		Node r1 = getRoot(n1);
		Node r2 = getRoot(n2);
		if(r1 != r2) {
			r1.p = r2;
		}
	}
	
}

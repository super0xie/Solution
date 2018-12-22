import java.util.HashMap;

public class LargestComponentSizebyCommonFactor {
	
	class Node{
		int v;
		Node p;
		int sz;
		Node(int v){
			this.v = v;
			sz = 1;
		}
	}
	
	private Node getRoot(Node n) {
		if(n.p == null) return n;
		else {
			Node r = getRoot(n.p);
			n.p = r;
			return r;
		}
	}
	
	int res = 1;
	private void union(Node n1, Node n2) {
		Node r1 = getRoot(n1);
		Node r2 = getRoot(n2);
		if(r1 != r2) {
			r1.p = r2;
			r2.sz += r1.sz;
			res = Math.max(res, r2.sz);
		}
	}
	
	public int largestComponentSize(int[] A) {
        HashMap<Integer, Node> map = new HashMap<>();
        for(int i : A) {
        	Node n = new Node(i);
        	double sqrt = Math.sqrt(i);
        	int sq = (int)Math.sqrt(i);
        	for(int j = 2; j <= sq; j++) {
        		if(i % j == 0) {
        			if(map.containsKey(j)) {
        				union(n, map.get(j));
        			}else {
        				map.put(j, n);
        			}
        			if(j != sqrt) {
        				int aux = i/j;
            			if(map.containsKey(aux)) {
            				union(n, map.get(aux));
            			}else {
            				map.put(aux, n);
            			}
        			}
        		}
        	}
        	if(i > 1) {
        		if(map.containsKey(i)) {
    				union(n, map.get(i));
    			}else {
    				map.put(i, n);
    			}
        	}
        	
        	
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] A = {2,3,6,7,4,12,21,39};
		LargestComponentSizebyCommonFactor test = new LargestComponentSizebyCommonFactor();
		System.out.println(test.largestComponentSize(A));
	}
	
}

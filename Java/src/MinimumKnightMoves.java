import java.util.HashSet;
import java.util.LinkedList;

public class MinimumKnightMoves {
	
	public int minKnightMovesOld(int x, int y) {
        HashSet<Integer> visited = new HashSet<>();
        if(x == 0 && y == 0) return 0;
        int[][] adj = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
        
        visited.add(0);
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        int move = 1;
        while(!q.isEmpty()) {
        	LinkedList<int[]> aux = new LinkedList<>();
        	while(!q.isEmpty()) {
        		int[] polled = q.poll();
        		
        		for(int k = 0; k < adj.length; k++) {
        			int m = polled[0] + adj[k][0];
        			int n = polled[1] + adj[k][1];
        			
        			int encode = 1000 * m + n;
        			if(!visited.contains(encode)) {
        				visited.add(encode);
        				if(m == x && n == y) return move;
        				aux.add(new int[] {m, n});
        			}
        		}
        	}
        	
        	q = aux;
        	move++;
        	
        }
        return -1;
        
    }
	
	public int minKnightMoves(int x, int y) {
        HashSet<Integer> visited = new HashSet<>();
        
        x = Math.abs(x);
        y = Math.abs(y);
        if(x < y) {
        	int tmp = x;
        	x = y;
        	y = tmp;
        }
        
        
        if(x == 0 && y == 0) return 0;
        if(x == 1 && y == 0) return 3;
        if(x == 1 && y == 1) return 2;
        if(x == 2 && y == 0) return 2;
        int[][] adj = {{1, 2}, {2, 1}};
        
        visited.add(0);
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        int move = 1;
        while(!q.isEmpty()) {
        	LinkedList<int[]> aux = new LinkedList<>();
        	while(!q.isEmpty()) {
        		int[] polled = q.poll();
        		
        		for(int k = 0; k < adj.length; k++) {
        			int m = polled[0] + adj[k][0];
        			int n = polled[1] + adj[k][1];
        			
        			if(m < n) {
        	        	int tmp = m;
        	        	m = n;
        	        	n = tmp;
        	        }
        			
        			int encode = 1000 * m + n;
        			if(!visited.contains(encode)) {
        				visited.add(encode);
        				if(m == x && n == y) return move;
        				aux.add(new int[] {m, n});
        			}
        		}
        	}
        	
        	q = aux;
        	move++;
        	
        }
        return -1;
        
    }
	
	public static void main(String[] args) {
		MinimumKnightMoves test = new MinimumKnightMoves();
		System.out.println(test.minKnightMoves(5, 5));
	}
	
}

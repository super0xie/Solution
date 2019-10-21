import java.util.HashSet;
import java.util.LinkedList;

public class MinimumMovestoReachTargetwithRotations {
	
	
	class Node{
		int i;
		int j;
		boolean horizontal;
		int encode;
		
		Node(int r, int c, boolean h){
			i = r;
			j = c;
			horizontal = h;
			
			if(horizontal) encode = 10000;
			encode += i * 100 + j;
		}
	}
	
	public int minimumMoves(int[][] grid) {
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Node> q = new LinkedList<>();
        int n = grid.length;
        Node init = new Node(0, 0, true);
        visited.add(init.encode);
        q.add(init);
        int move = 1;
        while(!q.isEmpty()) {
        	LinkedList<Node> aux = new LinkedList<>();
        	
        	while(!q.isEmpty()) {
        		Node polled = q.poll();
        		Node tmp = null;
        		if(polled.horizontal) {
        			if(polled.j + 2 < n && grid[polled.i][polled.j+2] == 0) {
        				tmp = new Node(polled.i, polled.j+1, true);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        			
        			if(polled.i+1 < n && grid[polled.i+1][polled.j] == 0 && grid[polled.i+1][polled.j+1] == 0) {
        				tmp = new Node(polled.i+1, polled.j, true);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        				
        			if(polled.i+1 < n && grid[polled.i+1][polled.j] == 0 && grid[polled.i+1][polled.j+1] == 0) {
        				tmp = new Node(polled.i, polled.j, false);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        				
        		} else {
        			if(polled.j + 1 < n && grid[polled.i][polled.j+1] == 0 && grid[polled.i+1][polled.j+1] == 0) {
        				tmp = new Node(polled.i, polled.j+1, false);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        				
        			if(polled.i + 2 < n && grid[polled.i+2][polled.j] == 0) {
        				tmp = new Node(polled.i+1, polled.j, false);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        			
        			if(polled.j+1 < n && grid[polled.i][polled.j+1] == 0 && grid[polled.i+1][polled.j+1] == 0) {
        				tmp = new Node(polled.i, polled.j, true);
        				if(tmp.horizontal && tmp.i == n-1 && tmp.j == n-2) return move;
            			if(tmp != null && !visited.contains(tmp.encode)) {
            				visited.add(tmp.encode);
            				aux.add(tmp);
            			}
        			}
        		}
        		
        	}
        	
        	q = aux;
        	move++;
        }
		
		return -1;
    }
	
	public static void main(String[] args) {
		MinimumMovestoReachTargetwithRotations test = new MinimumMovestoReachTargetwithRotations();
		int[][] grid = {{0,0,1,1,1,1},
				{0,0,0,0,1,1},
				{1,1,0,0,0,1},
				{1,1,1,0,0,1},
				{1,1,1,0,0,1},
				{1,1,1,0,0,0}};
		
		System.out.print(test.minimumMoves(grid));
		
	}
	
}

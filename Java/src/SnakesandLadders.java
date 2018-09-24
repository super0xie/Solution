import java.util.HashSet;
import java.util.LinkedList;

public class SnakesandLadders {
	
	public int snakesAndLadders(int[][] board) {
        int n = board.length * board.length;
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(1);
        int res = 1;
        
        while(!queue.isEmpty()) {
        	LinkedList<Integer> aux = new LinkedList<Integer>();
        	
        	while(!queue.isEmpty()) {
        		int polled = queue.poll();
        		
        		for(int i = 1; i <= 6; i++) {
        			int target = polled+i;
        			
        			if(target > n) break;
        			int r = board.length - 1 - (target-1) / board.length;
        			
        			int c = 0;
        			if(((target-1) / board.length) % 2 == 0) {
        				c = (target - 1) % board.length;
        			}else {
        				c = board.length - 1 - (target - 1) % board.length;
        			}
                	
                	if(board[r][c] != -1) {
                		target = board[r][c];
                	}
                	
                	if(target == n) return res;
                	
                	if(!visited.contains(target)) {
                		aux.add(target);
                		visited.add(target);
                	}
        		}
        	}
        	queue = aux;
        	res++;
        	
        }
        
        return -1;
    }
	
	
	
	public static void main(String[] args) {
		int[][] board = {{-1,-1,-1},{-1,9,8},{-1,8,9}};
		SnakesandLadders test = new SnakesandLadders();
		test.snakesAndLadders(board);
	}
	
}

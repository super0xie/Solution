import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SlidingPuzzle {
	
	private class Node {
		int[][] board;
		int i;
		int j;
		String hash;
		
		Node(int[][] b){
			this.hash = "";
			this.board = new int[2][3];
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3; j++) {
					this.board[i][j] = b[i][j];
					if(this.board[i][j] == 0) {
						this.i = i;
						this.j = j;
					}
					this.hash += b[i][j];
				}
			}
		}
		
		List<Node> neighbor(){
			List<Node> res = new ArrayList<Node>();
			if(i > 0) {
				swap(this.board, i, j, i-1, j);
				res.add(new Node(this.board));
				swap(this.board, i, j, i-1, j);
			}
			
			if(i < this.board.length-1) {
				swap(this.board, i, j, i+1, j);
				res.add(new Node(this.board));
				swap(this.board, i, j, i+1, j);
			}
			
			if(j > 0) {
				swap(this.board, i, j, i, j-1);
				res.add(new Node(this.board));
				swap(this.board, i, j, i, j-1);
			}
			
			if(j < this.board[0].length-1) {
				swap(this.board, i, j, i, j+1);
				res.add(new Node(this.board));
				swap(this.board, i, j, i, j+1);
			}
			
			return res;
		}
		
		void swap(int[][] b, int i, int j, int m, int n) {
			int aux = b[i][j];
			b[i][j] = b[m][n];
			b[m][n] = aux;
			
		}
		
	}
	
	public int slidingPuzzle(int[][] board) {
		LinkedList<Node> queue = new LinkedList<Node>();
		int res = 0;
		HashSet<String> visited = new HashSet<String>();
		queue.add(new Node(board));
		
		while(!queue.isEmpty()) {
			LinkedList<Node> aux = new LinkedList<Node>();
			
			while(!queue.isEmpty()) {
				Node poped = queue.remove();
				visited.add(poped.hash);
				
				if(poped.hash.equals("123450")) return res;
				for(Node n : poped.neighbor()) {
					if(!visited.contains(n.hash)) aux.add(n);
				}
				
			}
			
			queue = aux;
			res++;
			
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		int[][] board = {{4,1,2},{5,0,3}};
		SlidingPuzzle test = new SlidingPuzzle();
		System.out.println(test.slidingPuzzle(board));
	}

}

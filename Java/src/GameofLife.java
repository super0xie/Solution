
public class GameofLife {
	
	public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		scan(board, i, j);
        	}
        }
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		update(board, i, j);
        	}
        }
    }
	
//	2 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//	3 Any live cell with two or three live neighbors lives on to the next generation.
//	4 Any live cell with more than three live neighbors dies, as if by over-population..
//	5 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	
	private void scan(int [][] board, int i, int j) {
		int count = 0;
		for(int _i = i-1; _i <= i+1; _i++) {
			for(int _j = j-1; _j <= j+1; _j++) {
				if(_i >= 0 && _i < board.length && _j >=0 && _j < board[0].length && !(_i==i && _j==j)) {
					switch(board[_i][_j]){
					case 1:
					case 2:
					case 3:
					case 4:
						count++;
					}
					
				}
			}
		}
		
		if(board[i][j] == 1) {
			if(count < 2) {
				board[i][j] = 2;
			}else if(count <= 3) {
				board[i][j] = 3;
			}else {
				board[i][j] = 4;
			}
		}else {
			if(count == 3) board[i][j] = 5;
		}
		
	}
	
	private void update(int [][] board, int i, int j) {
		switch(board[i][j]) {
		case 2:
			board[i][j] = 0;
			break;
		case 3:
			board[i][j] = 1;
			break;
		case 4:
			board[i][j] = 0;
			break;
		case 5:
			board[i][j] = 1;
			break;
		}
	}
	
	public static void main(String[] args) {
		int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		GameofLife test = new GameofLife();
		test.gameOfLife(board);
		
	}
}
